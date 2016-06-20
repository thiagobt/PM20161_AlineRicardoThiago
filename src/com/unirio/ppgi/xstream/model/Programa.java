package com.unirio.ppgi.xstream.model;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

@XStreamAlias("programa")
public class Programa {

	@XStreamAsAttribute
	private String nome;
	@XStreamImplicit(itemFieldName = "linha")
	private List<LinhaPesquisa> linha;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<LinhaPesquisa> getLinha() {
		return linha;
	}

	public void setLinha(List<LinhaPesquisa> linha) {
		this.linha = linha;
	}

}