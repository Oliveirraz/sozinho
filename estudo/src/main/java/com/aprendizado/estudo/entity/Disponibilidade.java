package com.aprendizado.estudo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "disponibilidade")
public class Disponibilidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
}
