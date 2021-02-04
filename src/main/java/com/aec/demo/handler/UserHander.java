package com.aec.demo.handler;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.aec.demo.dds.pub.UserPublisher;
import com.aec.demo.domain.User;
import com.aec.demo.domain.kafka.sqlserver.Field;
import com.aec.demo.domain.kafka.sqlserver.Kafka;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class UserHander {

	private static final Logger logger = LogManager.getLogger(UserHander.class);
	@Autowired
	private ObjectMapper objectMapper;
	
	@Autowired
	private UserPublisher userPublisher;
	
//	@KafkaListener( groupId = "user_01_dds",topics = "${services.kafka.dds-demo.topic.name.user}", containerFactory = "kafkaListenerContainerFactory")
//	public void listenerProject(String message){
//		JavaType type = objectMapper.getTypeFactory().constructParametricType(Kafka.class, User.class);
//    	Kafka<User> k = null;
//    	Field[]fields = null;
//    	User user = null;
//    	try {
//			k =  objectMapper.readValue(message, type);	
//			fields = k.getSchema().getFields()[1].getFields();
//    		user = (User)k.getPayload().getAfter();
//		}catch(JsonProcessingException e) {
//			logger.error("Could not parse Project "+e.getMessage()); 	
//		}catch (Exception e) {
//			logger.error(e.getMessage());
//		}
//    
//    	if(fields != null && user != null) {
//    		userPublisher.write(user, fields);
//    	}else {
//    	   logger.info("Field Not match");
//    	}
//   	}	
}
