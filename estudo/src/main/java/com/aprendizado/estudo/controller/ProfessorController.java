package com.aprendizado.estudo.controller;

import com.aprendizado.estudo.RequestDTO.ProfessorRequestDTO;
import com.aprendizado.estudo.ResponseDTO.ProfessorResponseDTO;
import com.aprendizado.estudo.service.aluno.professor.ProfessorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("professores")
public class ProfessorController {

    private final ProfessorService professorService;

    public ProfessorController(ProfessorService professorService) {
        this.professorService = professorService;
    }


    @PostMapping
    public ProfessorResponseDTO criar(@RequestBody ProfessorRequestDTO dto) {
        return professorService.criarProfessor(dto);
    }

    @GetMapping
    public List<ProfessorResponseDTO> listarTodos() {
        return professorService.listarTodos();
    }

    @GetMapping("/{id}")
    public ProfessorResponseDTO buscarPorId(@PathVariable Integer id) {
        return professorService.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public ProfessorResponseDTO atualizar(@PathVariable Integer id,
                                          @RequestBody ProfessorRequestDTO dto) {
        return professorService.atualizarProfessor(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Integer id) {
        professorService.deletarProfessor(id);
    }


}
