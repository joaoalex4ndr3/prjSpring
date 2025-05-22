package com.ranpi.demo.entities;

import java.util.List; // ✅ import correto

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="tb_aluno")
public class Aluno {
    
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String nome;
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
    	name="aluno_curso", 
        joinColumns = @JoinColumn(name="aluno_id"),
        inverseJoinColumns = @JoinColumn(name="curso_id")
    )
    private List<Curso> cursos;

	public Aluno(Long id, String nome, List<Curso> cursos) {
		super();
		this.id = id;
		this.nome = nome;
		this.cursos = cursos;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}

    
}
