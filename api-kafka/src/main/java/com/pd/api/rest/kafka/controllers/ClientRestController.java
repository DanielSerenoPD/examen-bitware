package com.pd.api.rest.kafka.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.pd.api.rest.kafka.models.dao.IClientDao;
import com.pd.api.rest.kafka.models.document.Client;
import com.pd.api.rest.kafka.models.services.producer.ClientProducerService;

import java.util.List;

@RestController
@RequestMapping("/api-rest")
public class ClientRestController {

  @Autowired
  private final IClientDao clientRepository;
  private final ClientProducerService producer;

  public ClientRestController(IClientDao clientRepository, ClientProducerService producer) {
    this.clientRepository = clientRepository;
    this.producer = producer;
  }

  @RequestMapping(value = "/clients", method = RequestMethod.GET)
  public List<Client> getClients() {
    return clientRepository.findAll();
  }

  @RequestMapping(value = "/client", method = RequestMethod.POST)
  public void insertClient(@RequestBody String message) {
      producer.sendMessage(message);
  }
}
