package com.cwc.kafka.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cwc.kafka.model.Message;
import com.cwc.kafka.service.MessageService;

@RestController
@RequestMapping("/api/v1/kafka")
public class MessageController {
	
	private MessageService messageService;

	@Autowired
	public MessageController(MessageService messageService) {
		this.messageService = messageService;
	}
	
	@PostMapping("/")
	public ResponseEntity<Message> saveMessage(@RequestBody Message message){
		Message addMessage = this.messageService.addMessage(message);
		return new ResponseEntity<>(addMessage,HttpStatus.CREATED);
	}
	
	@GetMapping("/read/{messageId}")
	public ResponseEntity<Message> getSingleMesage(@PathVariable("messageId") Integer messageId){
		Message singleMessage = this.messageService.getSingleMessage(messageId);
		return new ResponseEntity<Message>(singleMessage,HttpStatus.FOUND);
	}
	
	@GetMapping("/read")
	public ResponseEntity<List<Message>> readAllMessage(){
		List<Message> allMessage = this.messageService.getAllMessage();
		return new ResponseEntity<List<Message>>(allMessage,HttpStatus.OK);
	}

}
