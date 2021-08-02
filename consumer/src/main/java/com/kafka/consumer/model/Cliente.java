package com.kafka.consumer.model;

import lombok.*;

@Builder
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {
    private String id;
    private String nome;
    private Integer idade;
}
