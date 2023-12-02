package com.cwc.kafka.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cwc.kafka.model.Message;
import com.cwc.kafka.repository.MessageRepository;
import com.cwc.kafka.service.MessageService;
import com.cwc.kafka.service.kafkaservice.KafkaProducer;

@Service
public class MessageServiceImpl implements MessageService {

	private KafkaProducer kafkaProducer;

	private MessageRepository messageRepository;

	@Autowired
	public MessageServiceImpl(MessageRepository messageRepository, KafkaProducer kafkaProducer) {
		this.messageRepository = messageRepository;
		this.kafkaProducer = kafkaProducer;
	}

	@Override
	public Message addMessage(Message message) {
		Message savedMessage = this.messageRepository.save(message);
		// Send a message to kafka
		kafkaProducer.sendMessage("Entity with ID " + savedMessage.getMessageId() + " created.");
		return savedMessage;
	}

	@Override
	public Message getSingleMessage(int messageId) {
		return this.messageRepository.findById(messageId).orElseThrow(() -> new RuntimeException("message id " + messageId + " not found "));
	}

	@Override
	public List<Message> getAllMessage() {
		return this.messageRepository.findAll();
	}

}
