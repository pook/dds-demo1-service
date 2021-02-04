package com.aec.demo.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.KafkaAdmin;

//@Configuration
//@ConfigurationProperties(prefix = "services.kafka.ddsdemo.topic.name")
public class KafkaTopicConfig {

	@Value("${services.kafka.ddsdemo.bootstrapservers}")
	private String bootstrapservers;

//	private String test;
//	private String user;
//	private String address;
	private String user;

	@Bean
	public KafkaAdmin kafkaAdmin() {		
		Map<String, Object> configs = new HashMap<>();
		configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, getBootstrapservers());
		return new KafkaAdmin(configs);
	}

//	@Bean
//	public NewTopic topic1() {
//		return TopicBuilder.name(test).build();
//	}
//	
//	@Bean
//	public NewTopic userTopic() {
//		return TopicBuilder.name(user).build();
//	}
//	
//	@Bean
//	public NewTopic addressTopic() {
//		return TopicBuilder.name(address).build();
//	}
	
	@Bean
	public NewTopic userTopic() {
		return TopicBuilder.name(user).build();
	}

//	public String getTest() {
//		return test;
//	}
//
//	public void setTest(String test) {
//		this.test = test;
//	}
//	
//	public String getUser() {
//		return user;
//	}
//
//	public void setUser(String user) {
//		this.user = user;
//	}
	public String getBootstrapservers() {
		return bootstrapservers;
	}

	public void setBootstrapservers(String bootstrapservers) {
		this.bootstrapservers = bootstrapservers;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

//	public String getAddress() {
//		return address;
//	}
//
//	public void setAddress(String address) {
//		this.address = address;
//	}

	


}
