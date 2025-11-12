package com.aprendizado.estudo.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Aluno")
@Getter
@Setter
public class Aluno extends Ususario{

    @ManyToMany(mappedBy = "alunos")
    private List<Aula> aulas = new ArrayList<>();

}
