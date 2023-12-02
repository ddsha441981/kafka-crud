package com.cwc.kafka.service.kafkaservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {
	private Logger log = LoggerFactory.getLogger(KafkaConsumer.class);


	@KafkaListener(topics = "my-topic", groupId = "abc")
	public void consume(String msg) {
		  log.info("MESSAGE RECEIVED AT CONSUMER END -> " + msg);
		System.out.println("Received message: " + msg);
	}
}
