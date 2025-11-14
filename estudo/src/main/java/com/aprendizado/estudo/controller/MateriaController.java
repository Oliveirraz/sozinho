package com.aprendizado.estudo.controller;

import com.aprendizado.estudo.RequestDTO.MateriaRequestDTO;
import com.aprendizado.estudo.ResponseDTO.MateriaResponseDTO;
import com.aprendizado.estudo.service.aluno.materia.MateriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("materias")
public class MateriaController {

    @Autowired
    private MateriaService materiaService;

    @PostMapping
    public MateriaResponseDTO criar(@RequestBody MateriaRequestDTO dto) {
        return materiaService.criar(dto);
    }

    @GetMapping
    public List<MateriaResponseDTO> listarTodos() {
        return materiaService.listarTodos();
    }

    @GetMapping("/{id}")
    public MateriaResponseDTO buscarPorId(@PathVariable Integer id) {
        return materiaService.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public MateriaResponseDTO atualizar(@PathVariable Integer id,
                                        @RequestBody MateriaRequestDTO dto) {
        return materiaService.atualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Integer id) {
        materiaService.deletar(id);
    }

}
