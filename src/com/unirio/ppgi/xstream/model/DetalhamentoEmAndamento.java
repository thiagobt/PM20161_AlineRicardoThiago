package com.unirio.ppgi.xstream.model;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

@XStreamAlias("DETALHAMENTO-DE-OUTRAS-ORIENTACOES-EM-ANDAMENTO")
public class DetalhamentoEmAndamento{

	@XStreamAsAttribute
	@XStreamAlias("CODIGO-CURSO")
	private String codigoCurso;

	public String getCodigoCurso() {
		return codigoCurso;
	}

	public void setCodigoCurso(String codigoCurso) {
		this.codigoCurso = codigoCurso;
	}

}

