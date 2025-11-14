package com.aprendizado.estudo.service.aluno;

import com.aprendizado.estudo.RequestDTO.AlunoRequestDTO;
import com.aprendizado.estudo.ResponseDTO.AlunoResponseDTO;
import com.aprendizado.estudo.ResponseDTO.MateriaResponseDTO;
import com.aprendizado.estudo.entity.Aluno;
import com.aprendizado.estudo.entity.Aula;
import com.aprendizado.estudo.entity.Materia;
import com.aprendizado.estudo.exception.ResourceNotFoundException;
import com.aprendizado.estudo.repository.AlunoRepository;
import com.aprendizado.estudo.repository.MateriaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
@RequiredArgsConstructor
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private MateriaRepository materiaRepository;

    public AlunoResponseDTO criarAluno(AlunoRequestDTO alunoDTO){
        Aluno aluno = new Aluno();
        aluno.setNome(alunoDTO.nome());
        aluno.setEmail(alunoDTO.email());
        aluno.setSenha(alunoDTO.senha());

        if (alunoDTO.materiasIDs() != null && !alunoDTO.materiasIDs().isEmpty()){
            List<Materia> materias = materiaRepository.findAllById(alunoDTO.materiasIDs());
            aluno.setMaterias(materias);
        }
        Aluno alunoSalvo = alunoRepository.save(aluno);
        return toResponseDTO(alunoSalvo);//Monta meu DTO
    }

    public List<AlunoResponseDTO> listarTodos() {
        return alunoRepository.findAll()
                .stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }

    public AlunoResponseDTO buscarPorId(int id) {
        Aluno aluno = alunoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado"));
        return toResponseDTO(aluno);
    }

    private AlunoResponseDTO toResponseDTO(Aluno aluno) {
        // Converte as matérias do aluno em DTOs
        List<MateriaResponseDTO> materias = aluno.getMaterias()
                .stream()
                .map(m -> new MateriaResponseDTO(
                        m.getId(),
                        m.getNome(),
                        m.getDescricao()
                ))
                .collect(Collectors.toList());

        // Pega apenas os IDs das aulas
        List<Integer> aulasIds = aluno.getAulas()
                .stream()
                .map(Aula::getId)
                .collect(Collectors.toList());

        return new AlunoResponseDTO(
                aluno.getId(),
                aluno.getNome(),
                aluno.getEmail(),
                materias,
                aulasIds
        );
    }

    public AlunoResponseDTO atualizarAluno(int id, AlunoRequestDTO alunoDTO) {
        Aluno aluno = alunoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Aluno não encontrado"));

        aluno.setNome(alunoDTO.nome());
        aluno.setEmail(alunoDTO.email());
        aluno.setSenha(alunoDTO.senha());

        if (alunoDTO.materiasIDs() != null && !alunoDTO.materiasIDs().isEmpty()) {
            List<Materia> materias = materiaRepository.findAllById(alunoDTO.materiasIDs());
            aluno.setMaterias(materias);
        } else {
            aluno.getMaterias().clear();
        }

        Aluno atualizado = alunoRepository.save(aluno);
        return toResponseDTO(atualizado);
    }

    public void deletarAluno(int id) {
        if (!alunoRepository.existsById(id)) {
            throw new RuntimeException("Aluno não encontrado para exclusão");
        }
        alunoRepository.deleteById(id);
    }

}
