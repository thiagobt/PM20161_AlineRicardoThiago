package com.unirio.ppgi.xstream.model;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

@XStreamAlias("TRABALHOS-EM-EVENTOS")
public class TrabalhosEventos {

	@XStreamImplicit(itemFieldName = "TRABALHO-EM-EVENTOS")
	private List<TrabalhoEventos> trabEventos;

	public List<TrabalhoEventos> getTrabEventos() {
		return trabEventos;
	}

	public void setTrabEventos(List<TrabalhoEventos> trabEventos) {
		this.trabEventos = trabEventos;
	}

}
