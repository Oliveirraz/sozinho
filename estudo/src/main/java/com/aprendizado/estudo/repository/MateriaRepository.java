package com.aprendizado.estudo.repository;

import com.aprendizado.estudo.entity.Materia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MateriaRepository extends JpaRepository<Materia, Integer> {
}
