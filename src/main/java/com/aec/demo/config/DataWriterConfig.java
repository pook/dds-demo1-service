package com.aec.demo.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.rti.dds.domain.DomainParticipant;
import com.rti.dds.infrastructure.StatusKind;
import com.rti.dds.publication.DataWriter;
import com.rti.dds.publication.DataWriterQos;
import com.rti.dds.publication.Publisher;

@Configuration
//@Import(DomainParticipant.class)
public class DataWriterConfig extends TopicConfig{

//	private static final Logger logger = LogManager.getLogger(DDSDataWriterConfig.class);
	
	@Bean(name="userDataWriter")
    public DataWriter createProjectDataWriter(@Qualifier("domainParticipant")DomainParticipant domainParticipant, @Qualifier("publisher")Publisher publisher, @Qualifier("dataWriterQos")DataWriterQos dwQos) {
    	return publisher.create_datawriter(
                createUserTopic(domainParticipant),
                dwQos,
                null,
                StatusKind.STATUS_MASK_NONE);
    }
	

}
