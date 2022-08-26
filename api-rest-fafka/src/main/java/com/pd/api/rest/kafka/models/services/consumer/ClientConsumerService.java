package com.pd.api.rest.kafka.models.services.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.pd.api.rest.kafka.models.dao.IClientDao;
import com.pd.api.rest.kafka.models.document.Client;

@Service
public final class ClientConsumerService {

  private final IClientDao iClientDao;

  public ClientConsumerService(IClientDao iClientDao) {
    this.iClientDao = iClientDao;
  }

  @KafkaListener(topics = "clientes", containerFactory = "kafkaListenerContainerFactory")
  public void consume(Client client) {
    iClientDao.insert(client);
  }
}