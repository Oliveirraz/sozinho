package com.aprendizado.estudo.repository;

import com.aprendizado.estudo.entity.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno, Integer> {
}
