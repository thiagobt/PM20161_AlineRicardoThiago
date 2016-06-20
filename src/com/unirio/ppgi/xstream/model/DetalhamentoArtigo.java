package com.unirio.ppgi.xstream.model;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

@XStreamAlias("DETALHAMENTO-DO-ARTIGO")
public class DetalhamentoArtigo {

	@XStreamAsAttribute
	@XStreamAlias("TITULO-DO-PERIODICO-OU-REVISTA")
	private String titulo;

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

}
