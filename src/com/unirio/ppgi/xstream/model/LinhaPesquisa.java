package com.unirio.ppgi.xstream.model;

import java.io.Serializable;
import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

@XStreamAlias("linha")
public class LinhaPesquisa implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5525615199355359046L;

	@XStreamAsAttribute
	private String nome;
	@XStreamImplicit(itemFieldName = "professor")
	private List<Professor> professor;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Professor> getProfessor() {
		return professor;
	}

	public void setProfessor(List<Professor> professor) {
		this.professor = professor;
	}

}
