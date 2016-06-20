package com.unirio.ppgi.xstream.model;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

@XStreamAlias("DADOS-BASICOS-DO-ARTIGO")
public class DadosBasicosArtigo {

	@XStreamAsAttribute
	@XStreamAlias("TITULO-DO-ARTIGO")
	private String tituloArtigo;

	@XStreamAsAttribute
	@XStreamAlias("ANO-DO-TRABALHO")
	private String ano;

	public String getTituloArtigo() {
		return tituloArtigo;
	}

	public void setTituloArtigo(String tituloArtigo) {
		this.tituloArtigo = tituloArtigo;
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}
}
