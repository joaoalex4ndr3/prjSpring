package com.ranpi.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ranpi.demo.entities.Curso;
import com.ranpi.demo.repositories.CursoRepository;

@Service
public class CursoService {
    
    private final CursoRepository cursoRepository;
    
    @Autowired
    public CursoService(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }
    
    public Curso findCursoById(Long id) {
        Optional<Curso> curso = cursoRepository.findById(id);
        return curso.orElse(null);
    }
    
    public Curso insertCurso(Curso curso) {
        return cursoRepository.save(curso);
    }
    
    public List<Curso> findAllCursos() {
        return cursoRepository.findAll();
    }
    
    public List<Curso> buscarCursoPorAluno(String nomeAluno) {
        return cursoRepository.findCursoByAluno(nomeAluno);
    }
    
}
