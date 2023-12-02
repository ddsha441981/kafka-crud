package com.cwc.kafka.service;

import java.util.List;

import com.cwc.kafka.model.Message;

public interface MessageService {
	
	public Message addMessage(Message message);
	public Message getSingleMessage(int messageId);
	public List<Message> getAllMessage();

}
