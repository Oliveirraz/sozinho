package com.aprendizado.estudo.RequestDTO;

import java.util.List;

//O Request é para requisição, (Criação, Atualização).
public record AlunoRequestDTO(String nome, String email, String senha, List<Integer> materiasIDs) {

}
