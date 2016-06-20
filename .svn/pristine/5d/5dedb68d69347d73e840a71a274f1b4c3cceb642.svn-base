package com.unirio.ppgi.xstream.model;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

@XStreamAlias("PRODUCAO-BIBLIOGRAFICA")
public class ProducaoBibliografica {

	// ARTIGOS-PUBLICADO
	@XStreamImplicit(itemFieldName = "ARTIGOS-PUBLICADOS")
	private List<ArtigosPublicados> artigosPublicados;

	// TRABALHOS-EM-EVENTOS
	@XStreamImplicit(itemFieldName = "TRABALHOS-EM-EVENTOS")
	private List<TrabalhosEventos> trabEventos;
	
	@XStreamOmitField
	@XStreamAlias("LIVROS-E-CAPITULOS")
	private String livrosCapitulos;
	@XStreamOmitField
	@XStreamAlias("DEMAIS-TIPOS-DE-PRODUCAO-BIBLIOGRAFICA")
	private String demaisTiposProducao;
	@XStreamOmitField
	@XStreamAlias("ARTIGOS-ACEITOS-PARA-PUBLICACAO")
	private String artigosAceitos;
	@XStreamOmitField
	@XStreamAlias("TEXTOS-EM-JORNAIS-OU-REVISTAS")
	private String textosJornais;

	public List<ArtigosPublicados> getArtigosPublicados() {
		return artigosPublicados;
	}

	public void setArtigosPublicados(List<ArtigosPublicados> artigosPublicados) {
		this.artigosPublicados = artigosPublicados;
	}

	public List<TrabalhosEventos> getTrabEventos() {
		return trabEventos;
	}

	public void setTrabEventos(List<TrabalhosEventos> trabEventos) {
		this.trabEventos = trabEventos;
	}

}
