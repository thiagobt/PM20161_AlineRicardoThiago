package com.unirio.ppgi.xstream.model;


import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

@XStreamAlias("DADOS-BASICOS-DA-PARTICIPACAO-EM-BANCA-DE-MESTRADO")
public class DadosBasicosBanca {

	@XStreamAsAttribute
	@XStreamAlias("NATUREZA")
	private String natureza;
	@XStreamAsAttribute
	@XStreamAlias("ANO-DO-TRABALHO")
	private int ano;

	public String getNatureza() {
		return natureza;
	}

	public void setNatureza(String natureza) {
		this.natureza = natureza;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

}
