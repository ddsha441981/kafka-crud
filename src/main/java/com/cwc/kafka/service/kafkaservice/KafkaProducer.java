package com.cwc.kafka.service.kafkaservice;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {

	private Logger log = LoggerFactory.getLogger(KafkaProducer.class);

	private static final String TOPIC = "my-topic";

	
	private KafkaTemplate<String, String> kafkaTemplate;
	@Autowired
	public KafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
		this.kafkaTemplate = kafkaTemplate;
	}



	public void sendMessage(String msg) {
		log.info("MESSAGE SENT FROM PRODUCER END -> " + msg);
		kafkaTemplate.send(TOPIC, msg);
	}
}
