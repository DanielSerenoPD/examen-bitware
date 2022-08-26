package com.pd.api.rest.kafka.models.dao;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import com.pd.api.rest.kafka.models.document.Client;
@Repository
public interface IClientDao extends MongoRepository<Client, String> {
	
    
}