package com.cwc.kafka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
//@EnableKafka
public class KafkaCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafkaCrudApplication.class, args);
	}

}
