package com.ranpi.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ranpi.demo.entities.Curso;
import com.ranpi.demo.services.CursoService;

@RestController
@RequestMapping("/cursos")
public class CursoController {

    private final CursoService cursoService;

    public CursoController(CursoService cursoService) {
        this.cursoService = cursoService;
    }

    @PostMapping("/salvar")
    public Curso createCurso(@RequestBody Curso curso) {
        return cursoService.insertCurso(curso);
    }

    @GetMapping("/{id}")
    public Curso getCurso(@PathVariable Long id) {
        return cursoService.findCursoById(id);
    }

    @GetMapping("/listar")
    public List<Curso> getAllCursos() {
        return cursoService.findAllCursos();
    }

    @GetMapping("/curso-aluno/")
    public List<Curso> getCursoPorAluno(@RequestParam String nomeAluno) {
        return cursoService.buscarCursoPorAluno(nomeAluno);
    }
}

