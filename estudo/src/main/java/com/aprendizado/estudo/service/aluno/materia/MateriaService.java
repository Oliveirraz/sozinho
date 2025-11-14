package com.aprendizado.estudo.service.aluno.materia;


import com.aprendizado.estudo.RequestDTO.MateriaRequestDTO;
import com.aprendizado.estudo.ResponseDTO.MateriaResponseDTO;
import com.aprendizado.estudo.entity.Materia;
import com.aprendizado.estudo.exception.ResourceNotFoundException;
import com.aprendizado.estudo.repository.MateriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MateriaService {


    @Autowired
    private MateriaRepository materiaRepository;

    public MateriaResponseDTO criar(MateriaRequestDTO dto) {
        Materia materia = new Materia();
        materia.setNome(dto.nome());
        materia.setDescricao(dto.descricao());

        materiaRepository.save(materia);

        return toResponse(materia);
    }

    public List<MateriaResponseDTO> listarTodos() {
        return materiaRepository.findAll()
                .stream()
                .map(this::toResponse)
                .toList();
    }

    public MateriaResponseDTO buscarPorId(Integer id) {
        Materia materia = materiaRepository.findById(id)
                .orElseThrow(() ->  new RuntimeException("Matéria não encontrado"));

        return toResponse(materia);
    }

    public MateriaResponseDTO atualizar(Integer id, MateriaRequestDTO dto) {
        Materia materia = materiaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Matéria não encontrado"));

        materia.setNome(dto.nome());
        materia.setDescricao(dto.descricao());

        materiaRepository.save(materia);

        return toResponse(materia);
    }

    public void deletar(Integer id) {
        if (!materiaRepository.existsById(id)) {
            throw new RuntimeException("Matéria não encontrado para exclusão");
        }

        materiaRepository.deleteById(id);
    }

    private MateriaResponseDTO toResponse(Materia materia) {
        return new MateriaResponseDTO(
                materia.getId(),
                materia.getNome(),
                materia.getDescricao()
        );
    }


}
