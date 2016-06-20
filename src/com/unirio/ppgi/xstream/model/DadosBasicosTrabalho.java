package com.unirio.ppgi.xstream.model;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

@XStreamAlias("DADOS-BASICOS-DO-TRABALHO")
public class DadosBasicosTrabalho {

	@XStreamAsAttribute
	@XStreamAlias("TITULO-DO-TRABALHO")
	private String tituloTrabalho;
	
	@XStreamAsAttribute
	@XStreamAlias("ANO-DO-TRABALHO")
	private String ano;

	public String getTituloTrabalho() {
		return tituloTrabalho;
	}

	public void setTituloTrabalho(String tituloTrabalho) {
		this.tituloTrabalho = tituloTrabalho;
	}
	
	public String getAno() {
		return ano;
	}
	
	public void setAno(String ano) {
		this.ano = ano;
	}

}
