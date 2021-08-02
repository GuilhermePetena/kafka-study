package com.kafka.producer.model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Cliente {
    private String id;
    private String nome;
    private Integer idade;
}
