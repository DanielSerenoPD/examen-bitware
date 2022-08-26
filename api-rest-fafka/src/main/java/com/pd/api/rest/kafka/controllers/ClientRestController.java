package com.pd.api.rest.kafka.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.pd.api.rest.kafka.models.dao.IClientDao;
import com.pd.api.rest.kafka.models.document.Client;
import com.pd.api.rest.kafka.models.services.consumer.ClientConsumerService;
import com.pd.api.rest.kafka.models.services.producer.ClientProducerService;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api-rest")
public class ClientRestController {

  @Autowired
  private final IClientDao clientRepository;
  private final ClientProducerService producer;
  private final ClientConsumerService consumer;

  public ClientRestController(IClientDao clientRepository, ClientProducerService producer, ClientConsumerService consumer) {
    this.clientRepository = clientRepository;
    this.producer = producer;
    this.consumer = consumer;
  }

  @RequestMapping(value = "/NutriNET/Cliente", method = RequestMethod.GET)
  public ResponseEntity<List<Client>> getClients() {
	List<Client> list = clientRepository.findAll();
    return new ResponseEntity<>(list, HttpStatus.OK);
  }
  @RequestMapping(value = "/NutriNET/Cliente/{id}", method = RequestMethod.GET)
  public ResponseEntity<Optional<Client>> getClient(@PathVariable String id) {
	  try {
	  Optional<Client> client = clientRepository.findById(id);
	  return new ResponseEntity<>(client, HttpStatus.OK);
  }catch(Exception e) {
	  return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
  }
	  
  }
  @RequestMapping(value = "/NutriNET/Cliente/{id}", method = RequestMethod.PUT)
  public ResponseEntity<Client> updateClient(@PathVariable String id, @RequestBody Client updateClient) {
	  try {
	  Optional<Client> originalClient = clientRepository.findById(id);
	 Client client = originalClient.get();
		 client.setAge(updateClient.getAge());
		 client.setHeight(updateClient.getHeight());
		 client.setWeight(updateClient.getWeight());
		 client.setEmail(updateClient.getEmail());
	  	 client.setGeb(updateClient.getGeb());
	 clientRepository.save(client);
	 return new ResponseEntity<>(client, HttpStatus.OK);
	  }catch(Exception e) {
		  return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	  }
  }
  @RequestMapping(value = "/NutriNET/Cliente", method = RequestMethod.POST)
  public ResponseEntity<Client> insertClient(@RequestBody Client client) {
	  try {
          producer.send(client);
          consumer.consume(client);
          return new ResponseEntity<>(client, HttpStatus.OK);
  }catch(Exception e) {
	  return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
  }
  }
    
}
