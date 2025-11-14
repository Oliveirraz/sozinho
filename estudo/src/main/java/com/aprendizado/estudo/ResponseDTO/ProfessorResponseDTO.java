package com.aprendizado.estudo.ResponseDTO;

import com.aprendizado.estudo.entity.Materia;

import java.math.BigDecimal;
import java.util.List;

public record ProfessorResponseDTO(Integer id, String nome, String email, String perfil, BigDecimal valorHoraAula, List<MateriaResponseDTO> materias, List<Integer> aulasIds) {
}
