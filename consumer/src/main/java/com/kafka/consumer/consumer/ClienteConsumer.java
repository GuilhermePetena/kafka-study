package com.kafka.consumer.consumer;

import com.kafka.consumer.model.Cliente;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ClienteConsumer {

    private static final Logger log = LoggerFactory.getLogger(ClienteConsumer.class);

    @Value(value = "${topic.name}")
    private String topic;

    @Value(value = "${spring.kafka.group-id}")
    private String groupId;

    @KafkaListener(topics = "${topic.name}", groupId = "${spring.kafka.group-id}", containerFactory = "clienteKafkaListenerContainerFactory")
    public void listenTopicCliente(ConsumerRecord<String, Cliente> record){
        log.info("Received Message " + record.topic());
        log.info("Received Message " + record.value());
        log.info("Received Message " + record.partition());
    }
}
