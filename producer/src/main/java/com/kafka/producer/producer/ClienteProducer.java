package com.kafka.producer.producer;

import com.kafka.producer.model.Cliente;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ClienteProducer {

    private static final Logger logger = LoggerFactory.getLogger(ClienteProducer.class);
    private final String topic;
    private final KafkaTemplate<String, Cliente> kafkaTemplate;

    public ClienteProducer(@Value("${topic.name}") String topic, KafkaTemplate<String, Cliente> kafkaTemplate) {
        this.topic = topic;
        this.kafkaTemplate = kafkaTemplate;
    }

    public void send(Cliente cliente){
        kafkaTemplate.send(topic, cliente).addCallback(
                success -> logger.info("Messagem send" + success.getProducerRecord().value()),
                failure -> logger.info("Message failure" + failure.getMessage())
        );
    }

}
