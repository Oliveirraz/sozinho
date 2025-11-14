package com.aprendizado.estudo.controller;

import com.aprendizado.estudo.RequestDTO.AlunoRequestDTO;
import com.aprendizado.estudo.ResponseDTO.AlunoResponseDTO;
import com.aprendizado.estudo.service.aluno.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("alunos")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    @PostMapping
    public AlunoResponseDTO criarAluno(@RequestBody AlunoRequestDTO alunoDTO){
        return alunoService.criarAluno(alunoDTO);
    }

    @GetMapping
    public List<AlunoResponseDTO> listarTodosAlunos(){
        return alunoService.listarTodos();
    }

    @GetMapping("{id}")
    public AlunoResponseDTO buscarPorId(@PathVariable int id){
        return alunoService.buscarPorId(id);
    }

    @PutMapping("{id}")
    public  AlunoResponseDTO atualizarAluno(@PathVariable int id, @RequestBody AlunoRequestDTO alunoRequestDTO){
        return alunoService.atualizarAluno(id, alunoRequestDTO);
    }

    @DeleteMapping("{id}")
    public void deletarAluno(@PathVariable int id){
        alunoService.deletarAluno(id);
    }
}
