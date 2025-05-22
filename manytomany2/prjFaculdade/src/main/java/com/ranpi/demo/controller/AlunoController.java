package com.ranpi.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ranpi.demo.entities.Aluno;
import com.ranpi.demo.services.AlunoService;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    private final AlunoService alunoService;

    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    @PostMapping("/salvar")
    public Aluno createAluno(@RequestBody Aluno aluno) {
        return alunoService.insertAluno(aluno);
    }

    @GetMapping("/{id}")
    public Aluno getAluno(@PathVariable Long id) {
        return alunoService.findAlunoById(id);
    }

    @GetMapping("/listar")
    public List<Aluno> getAllAlunos() {
        return alunoService.findAllAlunos();
    }

    @GetMapping("/por-curso")
    public List<Aluno> listarAlunoPorCurso(@RequestParam String nome) {
        return alunoService.BuscaAlunoPorCurso(nome);
    }
    
    @GetMapping("/nome/")
    public List<Aluno> buscaPorNome(@RequestParam String nome){
    	return alunoService.BuscarPorNomeContendo(nome);
    }
    
    @GetMapping("/multi-cursos")
    public List<Aluno> buscaAlunoComMaisCursos(){
    	return alunoService.BuscarAlunoComMaisDeUmCurso();
    }
}
