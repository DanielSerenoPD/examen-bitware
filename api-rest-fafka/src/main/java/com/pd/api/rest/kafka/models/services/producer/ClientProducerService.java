package com.pd.api.rest.kafka.models.services.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.pd.api.rest.kafka.models.document.Client;

@Service
public class ClientProducerService {
    private final Logger LOG = LoggerFactory.getLogger(ClientProducerService.class);
    @Autowired
    private KafkaTemplate<String, Client> kafkaTemplate;

    String kafkaTopic = "clientes";

    public void send(Client client) {
        LOG.info("JSON:", client);
        kafkaTemplate.send(kafkaTopic, client);
    }
}