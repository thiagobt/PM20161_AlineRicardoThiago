package com.unirio.ppgi.xstream.model;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

@XStreamAlias("DETALHAMENTO-DE-ORIENTACOES-EM-ANDAMENTO-PARA-DOUTORADO")
public class DadosBasicosEmAndamentoDoutorado {
	
	@XStreamAsAttribute
	@XStreamAlias("ANO")
	private String ano;
	
	public String getAno() {
		return ano;
	}
	
	public void setAno(String ano) {
		this.ano = ano;
	}

}
