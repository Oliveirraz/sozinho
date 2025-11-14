package com.aprendizado.estudo.service.aluno.professor;

import com.aprendizado.estudo.RequestDTO.ProfessorRequestDTO;
import com.aprendizado.estudo.ResponseDTO.MateriaResponseDTO;
import com.aprendizado.estudo.ResponseDTO.ProfessorResponseDTO;
import com.aprendizado.estudo.entity.Aula;
import com.aprendizado.estudo.entity.Materia;
import com.aprendizado.estudo.entity.Professor;
import com.aprendizado.estudo.repository.MateriaRepository;
import com.aprendizado.estudo.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProfessorService {

    @Autowired
    private ProfessorRepository professorRepository;

    @Autowired
    private MateriaRepository materiaRepository;


    public ProfessorResponseDTO criarProfessor(ProfessorRequestDTO dto) {
        Professor professor = new Professor();

        professor.setNome(dto.nome());
        professor.setEmail(dto.email());
        professor.setSenha(dto.senha());
        professor.setPerfil(dto.perfil());
        professor.setValorHoraAula(dto.valorHoraAula());

        if (dto.materiasIds() != null && !dto.materiasIds().isEmpty()) {
            List<Materia> materias = materiaRepository.findAllById(dto.materiasIds());
            professor.setMaterias(materias);
        }

        Professor salvo = professorRepository.save(professor);
        return toResponseDTO(salvo);
    }

    public List<ProfessorResponseDTO> listarTodos() {
        return professorRepository.findAll()
                .stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }


    public ProfessorResponseDTO buscarPorId(Integer id) {
        Professor professor = professorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Professor não encontrado"));
        return toResponseDTO(professor);
    }

    public ProfessorResponseDTO atualizarProfessor(Integer id, ProfessorRequestDTO dto) {
        Professor professor = professorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Professor não encontrado"));

        professor.setNome(dto.nome());
        professor.setEmail(dto.email());
        professor.setSenha(dto.senha());
        professor.setPerfil(dto.perfil());
        professor.setValorHoraAula(dto.valorHoraAula());

        if (dto.materiasIds() != null) {
            List<Materia> materias = materiaRepository.findAllById(dto.materiasIds());
            professor.setMaterias(materias);
        }

        Professor atualizado = professorRepository.save(professor);
        return toResponseDTO(atualizado);
    }

    public void deletarProfessor(Integer id) {
        Professor professor = professorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Professor não encontrado"));

        professorRepository.delete(professor);
    }


    private ProfessorResponseDTO toResponseDTO(Professor professor) {

        List<MateriaResponseDTO> materiasDTO = professor.getMaterias()
                .stream()
                .map(m -> new MateriaResponseDTO(
                        m.getId(),
                        m.getNome(),
                        m.getDescricao()
                ))
                .collect(Collectors.toList());

        List<Integer> aulasIds = professor.getAulas()
                .stream()
                .map(Aula::getId)
                .collect(Collectors.toList());

        return new ProfessorResponseDTO(
                professor.getId(),
                professor.getNome(),
                professor.getEmail(),
                professor.getPerfil(),
                professor.getValorHoraAula(),
                materiasDTO,
                aulasIds
        );
    }

}
