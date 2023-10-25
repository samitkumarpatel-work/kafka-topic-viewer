package com.example.kafkatopicviewer;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.DltHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.RetryableTopic;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.retry.annotation.Backoff;

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
	public void listen(ConsumerRecord<String, String> in, Acknowledgment acknowledgment) {

		log.info("Received: key: {} - {} - {}", in.offset(), in.key(), in.value());
	}

	/*@RetryableTopic(attempts = "5", backoff = @Backoff(delay = 2_000, maxDelay = 10_000, multiplier = 2))
	@KafkaListener(id = "fooGroup", topics = "topic4")
	public void listen(String in, @Header(KafkaHeaders.RECEIVED_TOPIC) String topic,
					   @Header(KafkaHeaders.OFFSET) long offset) {

		log.info("Received: {} from {} @ {}", in, topic, offset);
		if (in.startsWith("fail")) {
			throw new RuntimeException("failed");
		}
	}

	@DltHandler
	public void listenDlt(String in, @Header(KafkaHeaders.RECEIVED_TOPIC) String topic,
						  @Header(KafkaHeaders.OFFSET) long offset) {

		log.info("DLT Received: {} from {} @ {}", in, topic, offset);
	}*/

}
