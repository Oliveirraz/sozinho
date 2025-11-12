package com.aprendizado.estudo.entity;

import jakarta.persistence.*;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

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


    @ManyToMany
    @JoinTable(
            name = "aulas_alunos",
            joinColumns = @JoinColumn(name = "id_aula"),
            inverseJoinColumns = @JoinColumn(name = "id_aluno")
    )
    private List<Aluno> alunos = new ArrayList<>();

}
