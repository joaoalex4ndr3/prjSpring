package com.ranpi.demo.services;

import java.util.List; 
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ranpi.demo.entities.Aluno;
import com.ranpi.demo.repositories.AlunoRepository;

@Service
public class AlunoService {
    
    private final AlunoRepository alunoRepository;
    
    public AlunoService(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }
    
    public Aluno findAlunoById(Long id) {
        Optional<Aluno> aluno = alunoRepository.findById(id);
        return aluno.orElse(null);
    }
    
    public Aluno insertAluno(Aluno aluno) {
        return alunoRepository.save(aluno);
    }
    
    public List<Aluno> findAllAlunos() {
        return alunoRepository.findAll();
    }
    
    public List<Aluno> BuscaAlunoPorCurso(String nomeCurso) {
    	return alunoRepository.findAlunoByCurso(nomeCurso);
    }
    
    public List<Aluno> BuscarPorNomeContendo(String nome){
    	return alunoRepository.findAlunosComMaisDeUmCurso();
    }
    
    public List<Aluno> BuscarAlunoComMaisDeUmCurso(){
        return alunoRepository.findAlunosComMaisDeUmCurso();
    }
   
}
