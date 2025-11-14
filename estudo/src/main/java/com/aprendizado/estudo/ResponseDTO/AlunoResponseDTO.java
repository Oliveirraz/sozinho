package com.aprendizado.estudo.ResponseDTO;

import java.util.List;
//O ResponseDTO -> serve para trafegar os dados de forma segura, sem expor toda a entidade JPA.
public record AlunoResponseDTO(int id, String nome, String email, List<MateriaResponseDTO> materias, List<Integer> aulasId) {

}
