package com.kafka.producer.controller;

import com.kafka.producer.model.Cliente;
import com.kafka.producer.producer.ClienteProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteProducer clienteProducer;

    @PostMapping
    public ResponseEntity<Cliente> create(@RequestBody Cliente clienteRequest){
        Cliente cliente = Cliente.builder().id(UUID.randomUUID().toString()).idade(clienteRequest.getIdade()).nome(clienteRequest.getNome()).build();
        clienteProducer.send(cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(cliente);
    }
}
