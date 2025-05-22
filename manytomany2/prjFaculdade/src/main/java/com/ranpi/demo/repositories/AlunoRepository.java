package com.ranpi.demo.repositories;

import java.util.List; 

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ranpi.demo.entities.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
    
    @Query("SELECT a FROM Aluno a JOIN a.cursos c WHERE c.nomeCurso = :nomeCurso")
    List<Aluno> findAlunoByCurso(@Param("nomeCurso") String nomeCurso);
    
    
    @Query("SELECT a FROM Aluno a WHERE LOWER(a.nome) LIKE LOWER(CONCAT ('%',:nome,'%'))")
    List<Aluno> findByNomeContendo(@Param("nome")String nome);
    
    
    @Query("SELECT a FROM Aluno a WHERE SIZE(a.cursos)>1")
    List<Aluno> findAlunosComMaisDeUmCurso();
}
