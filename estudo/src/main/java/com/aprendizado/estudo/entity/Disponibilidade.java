package com.aprendizado.estudo.entity;

import jakarta.persistence.*;

import java.time.LocalTime;

@Entity
@Table(name = "disponibilidade")
public class Disponibilidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, name = "dia_da_semana")
    @Enumerated(EnumType.STRING)
    private DiaEnum diaDaSemana;

    private LocalTime horaDisponivel;



    public enum DiaEnum{
            SEGUNDA, TERCA, QUARTA,
        QUINTA, SEXTA;
    }
}
