package com.aprendizado.estudo.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "materia")
public class Materia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, name = "nome", length = 100)
    private String nome;

    @Column(nullable = false, name = "descricao")
    private String descricao;

    @ManyToMany(mappedBy = "materias")
    private List<Aluno> alunos = new ArrayList<>();

    @ManyToMany(mappedBy = "materias")
    private List<Professor> professores = new ArrayList<>();

}
