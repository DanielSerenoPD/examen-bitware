package com.pd.api.rest.kafka.models.services.consumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.pd.api.rest.kafka.models.dao.IClientDao;
import com.pd.api.rest.kafka.models.document.Client;

@Service
public final class ClientConsumerService {
  @Autowired
  private final IClientDao clientRepository;

  public ClientConsumerService(IClientDao clientRepository) {
    this.clientRepository = clientRepository;
  }

  @KafkaListener(topics = "Clients", containerFactory = "ClientsContainerFactory")
  public void consume(String message) {
    Client client = new Client();

    clientRepository.insert(client);
  }
}