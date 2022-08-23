package com.pd.api.rest.kafka.models.dao;
import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import com.pd.api.rest.kafka.models.document.Client;
@Repository
public interface IClientDao extends MongoRepository<Client, String> {
	Optional<Client> findById(String id);
	Client findByOffset(Long offset);

    @Query("{'offset' : { $gte: ?0, $lte: ?1 }}")
    List<Client> findInOffsetRange(Long lowerOffset, Long upperOffset);
}