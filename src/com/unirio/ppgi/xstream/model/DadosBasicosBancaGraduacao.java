package com.unirio.ppgi.xstream.model;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

@XStreamAlias("DADOS-BASICOS-DA-PARTICIPACAO-EM-BANCA-DE-GRADUACAO")
public class DadosBasicosBancaGraduacao {
	
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
