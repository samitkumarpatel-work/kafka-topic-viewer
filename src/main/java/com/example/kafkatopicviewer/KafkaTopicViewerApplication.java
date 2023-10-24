package com.example.kafkatopicviewer;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.KafkaListener;

@SpringBootApplication
@Slf4j
public class KafkaTopicViewerApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafkaTopicViewerApplication.class, args);
	}
	@Value("${spring.kafka.consumer.topic}")
	String topicName;

//	@Bean
//	NewTopic topic() {
//		return new NewTopic( topicName, 1, (short) 1);
//	}

	@KafkaListener(topics = "${spring.kafka.consumer.topic}")
	public void listen(String in) {
		log.info("Received: {}", in);
	}

}
