package com.ranpi.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ranpi.demo.entities.Curso;

public interface CursoRepository extends JpaRepository<Curso, Long> {

   
    @Query("SELECT c FROM Curso c JOIN c.alunos a WHERE a.nome = :nomeAluno")
    List<Curso> findCursoByAluno(@Param("nomeAluno") String nomeAluno);

   
}
