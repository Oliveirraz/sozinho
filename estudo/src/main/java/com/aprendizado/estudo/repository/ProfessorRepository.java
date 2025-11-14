package com.aprendizado.estudo.repository;

import com.aprendizado.estudo.entity.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorRepository extends JpaRepository<Professor, Integer> {
}
