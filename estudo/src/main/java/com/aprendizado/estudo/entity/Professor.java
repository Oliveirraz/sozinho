package com.aprendizado.estudo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "professor")
@Getter
@Setter
public class Professor extends Ususario{

    @Column(nullable = false, name = "perfil")
    private String prfil;

    @Column(nullable = false, name = "valorHoraAula", precision = 10, scale = 2)
    private BigDecimal valorHoraAula;


}
