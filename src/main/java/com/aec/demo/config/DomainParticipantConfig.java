package com.aec.demo.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.aec.demo.dds.DomainListener;
import com.rti.dds.domain.DomainParticipant;
import com.rti.dds.domain.DomainParticipantFactory;
import com.rti.dds.domain.DomainParticipantFactoryQos;
import com.rti.dds.domain.DomainParticipantListener;
import com.rti.dds.domain.DomainParticipantQos;
import com.rti.dds.infrastructure.StatusKind;
import com.rti.dds.publication.DataWriterQos;
import com.rti.dds.publication.Publisher;

@Configuration
public class DomainParticipantConfig {
	private static final Logger logger = LogManager.getLogger(DomainParticipantConfig.class);

	@Value("${dds.qosprofile.file}")
	private String profileFile;
	
	@Value("${dds.profile.lib.name}")
	private String profileLibName;
	
	@Value("${dds.profile.name}")
	private String profileName;
	
	@Value("${dds.domain.id}")
	private int domainId;
	
	
	@Bean(name="domainParticipant")
	public DomainParticipant createDomainParticipant(@Qualifier("domainParticipantFactory")DomainParticipantFactory factory) {
        DomainParticipantQos qos = new DomainParticipantQos();
        factory.get_participant_qos_from_profile(qos, profileLibName , profileName);
        DomainParticipantListener listener = new DomainListener();
        DomainParticipant participant  = factory.create_participant(
                domainId, qos, listener,
                (StatusKind.INCONSISTENT_TOPIC_STATUS |
                 StatusKind.OFFERED_INCOMPATIBLE_QOS_STATUS |
                 StatusKind.REQUESTED_INCOMPATIBLE_QOS_STATUS)); 
       
       return participant; 
     }	
	
	@Bean(name="domainParticipantFactory")
	public DomainParticipantFactory createDomainParticipantFactory() {
		DomainParticipantFactory factory = DomainParticipantFactory.get_instance();
		DomainParticipantFactoryQos factory_qos = new DomainParticipantFactoryQos();
		factory.get_qos(factory_qos);
		factory_qos.profile.url_profile.clear();
        factory_qos.profile.url_profile.add(profileFile);
        factory_qos.resource_limits.max_objects_per_thread = 2048;
        factory.set_qos(factory_qos);
        try {
            factory.reload_profiles();
        } catch (Exception e) {
            logger.error("Problem opening QOS profiles file " + profileFile + ".\n");
            logger.error(e);           
        }
        try {
            factory.set_default_library(profileLibName);
        } catch (Exception e) {
            logger.error("No QOS Library named profileLibName found in " + profileFile + ".\n");
            logger.error(e);
        }  
        return factory;
	}	
    
	@Bean(name="publisher")
	public Publisher createPublisher(@Qualifier("domainParticipant") DomainParticipant domainParticipant) {
		return domainParticipant.create_publisher_with_profile(profileLibName, profileName, null,
                StatusKind.STATUS_MASK_NONE);
	}
	
	@Bean(name="dataWriterQos")
	public DataWriterQos configureReaderQos(@Qualifier("domainParticipantFactory")DomainParticipantFactory factory) {
		DataWriterQos dwQos = new DataWriterQos();
        try {
            factory.get_datawriter_qos_from_profile(dwQos, profileLibName,profileName);
        } catch (Exception e) {
            logger.error("No QOS Profile named \"" + profileName + "\" found in QOS Library \""
                          + profileLibName + "\" in file " + profileFile + ".\n");
            logger.error(e.getMessage());
            return null;
        }
//        dwQos.durability.kind = DurabilityQosPolicyKind.VOLATILE_DURABILITY_QOS;
//        dwQos.resource_limits.initial_samples = sendQueueSize;
//        dwQos.resource_limits.max_samples_per_instance = dwQos.resource_limits.max_samples;
//        dwQos.durability.direct_communication = true;
//        dwQos.protocol.rtps_reliable_writer.heartbeats_per_max_samples = sendQueueSize / 10;
//        dwQos.protocol.rtps_reliable_writer.low_watermark = sendQueueSize * 1 / 10;
//        dwQos.protocol.rtps_reliable_writer.high_watermark = sendQueueSize * 9 / 10;
        return dwQos;
	}
}
