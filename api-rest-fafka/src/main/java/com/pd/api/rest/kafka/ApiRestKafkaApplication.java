package com.pd.api.rest.kafka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;

import com.pd.api.rest.kafka.models.document.Client;

@SpringBootApplication
public class ApiRestKafkaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiRestKafkaApplication.class, args);
	}
	@KafkaListener(topics = "clientes", groupId = "test")
    public void listen(Client client) {
		
        System.out.println(client.toString());
    }
}

