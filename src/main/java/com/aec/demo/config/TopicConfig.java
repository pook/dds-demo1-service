package com.aec.demo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import com.aec.demo.type.DDSUserTypeSupport;
import com.rti.dds.domain.DomainParticipant;
import com.rti.dds.infrastructure.StatusKind;
import com.rti.dds.topic.Topic;

@Configuration
public class TopicConfig {

//	private static final Logger logger = LogManager.getLogger(TopicConfig.class);

	@Value("${dds.topic.name.user}")
	private String topicUser;
	
	
	protected Topic createUserTopic(DomainParticipant domainParticipant) {
		String typeName = DDSUserTypeSupport.get_type_name(); 
		DDSUserTypeSupport.register_type(domainParticipant, typeName);
		return domainParticipant.create_topic(
				topicUser, typeName,
                DomainParticipant.TOPIC_QOS_DEFAULT, null,
                StatusKind.STATUS_MASK_NONE);
	}
	
}