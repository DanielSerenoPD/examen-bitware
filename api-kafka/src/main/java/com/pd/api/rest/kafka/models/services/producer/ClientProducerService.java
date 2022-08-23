package com.pd.api.rest.kafka.models.services.producer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Component
public final class ClientProducerService {

  private static final Logger logger = LoggerFactory.getLogger(ClientProducerService.class);

  @Autowired
  private final KafkaTemplate<String, String> kafkaTemplate;

  public ClientProducerService(KafkaTemplate<String, String> kafkaTemplate) {
    this.kafkaTemplate = kafkaTemplate;
  }

  public void sendMessage(String message) {
    String topicName = "Clients";
    ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send(topicName, message);

    future.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {
      @Override
      public void onFailure(Throwable throwable) {
        logger.error("Failed to send message", throwable);
      }

      @Override
      public void onSuccess(SendResult<String, String> stringStringSendResult) {
        logger.info("Sent message successfully");
      }
    });
  }
}
