package com.unirio.ppgi.xstream.model;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

@XStreamAlias("DADOS-BASICOS-DE-OUTRAS-ORIENTACOES-CONCLUIDAS")
public class DadosBasicosConcluidos {

	@XStreamAsAttribute
	@XStreamAlias("NATUREZA")
	private String natureza;
	@XStreamAsAttribute
	@XStreamAlias("ANO")
	private String ano;

	public String getNatureza() {
		return natureza;
	}

	public void setNatureza(String natureza) {
		this.natureza = natureza;
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

}
