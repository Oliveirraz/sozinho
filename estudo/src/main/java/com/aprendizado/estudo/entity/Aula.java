package com.aprendizado.estudo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Aula")
public class Aula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

}
