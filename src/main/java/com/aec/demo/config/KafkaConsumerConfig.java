package com.aec.demo.config;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;

import com.fasterxml.jackson.databind.deser.std.StringDeserializer;


//@EnableKafka
//@Configuration
//@ConfigurationProperties(prefix = "services.kafka.ddsdemo")
public class KafkaConsumerConfig {

	private String bootstrapservers;

	@Bean
	public Map<String, Object> consumerConfigs() {
		Map<String, Object> props = new HashMap<>();
		props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapservers);
		props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		props.put(ConsumerConfig.GROUP_ID_CONFIG, "GROUP_01");
		props.put(ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG, 30000);
		props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, true);
//		props.put(ConsumerConfig.METADATA_MAX_AGE_CONFIG, );
     	props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
     	props.put(ConsumerConfig.MAX_POLL_INTERVAL_MS_CONFIG, (int) TimeUnit.MINUTES.toMillis(10));
		return props;
	}

	public String getBootstrapservers() {
		return bootstrapservers;
	}

	public void setBootstrapservers(String bootstrapservers) {
		this.bootstrapservers = bootstrapservers;
	}

	@Bean
	public ConsumerFactory<String, String> consumerFactory() {
		return new DefaultKafkaConsumerFactory<>(consumerConfigs());
	}

	@Bean
	public KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<String, String>> kafkaListenerContainerFactory() {
		ConcurrentKafkaListenerContainerFactory<String, String> factory = new ConcurrentKafkaListenerContainerFactory<>();
		factory.setConsumerFactory(consumerFactory());
		return factory;
	}

//	public ConsumerFactory<String, Project> projectConsumerFactory() {
////		JsonDeserializer<Project> deserializer = new JsonDeserializer<>(Project.class);
//		Map<String, Object> props = new HashMap<>();
//		props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, getBootstrapservers());
//		props.put(ConsumerConfig.GROUP_ID_CONFIG, "cbms-project-1");
//		props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
////		props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
////		props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, deserializer);
//		return new DefaultKafkaConsumerFactory<>(props, new StringDeserializer(),
//				 new JsonDeserializer<>(Project.class));
//	}
//	
//	 @Bean
//	  public ConcurrentKafkaListenerContainerFactory<String, Project> projectKafkaListenerContainerFactory() {
//	    ConcurrentKafkaListenerContainerFactory<String, Project> factory =
//	      new ConcurrentKafkaListenerContainerFactory<>();
//	    factory.setConsumerFactory(projectConsumerFactory());
//	    return factory;
//	  }

}
