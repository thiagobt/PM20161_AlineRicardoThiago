package com.unirio.ppgi.xstream.model;

import java.io.Serializable;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

@XStreamAlias("professor")
public class Professor implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7561595030619270104L;

	@XStreamAsAttribute
	private String codigo;
	@XStreamAsAttribute
	private String nome;

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
