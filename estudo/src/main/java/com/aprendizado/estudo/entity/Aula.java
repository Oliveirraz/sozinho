package com.aprendizado.estudo.entity;

import jakarta.persistence.*;

import java.sql.Time;

@Entity
@Table(name = "Aula")
public class Aula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, name = "horaInicio")
    private Time horaInicio;

    @Column(nullable = false, name = "horaFim")
    private Time horaFim;


}
