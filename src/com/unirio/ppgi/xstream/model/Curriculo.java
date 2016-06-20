package com.unirio.ppgi.xstream.model;

import java.io.Serializable;
import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamImplicit;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

@XStreamAlias("CURRICULO-VITAE")
public class Curriculo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6545790161095326250L;
	@XStreamAsAttribute
	@XStreamAlias("SISTEMA-ORIGEM-XML")
	private String sistemaOrigemXml;
	@XStreamAsAttribute
	@XStreamAlias("NUMERO-IDENTIFICADOR")
	private String numeroIdentificador;
	@XStreamAsAttribute
	@XStreamAlias("DATA-ATUALIZACAO")
	private String dataAtualizacao;
	@XStreamAsAttribute
	@XStreamAlias("HORA-ATUALIZACAO")
	private String horaAtualizacao;

	@XStreamOmitField
	@XStreamAlias("DADOS-GERAIS")
	private String dadosGerais;
	@XStreamOmitField
	@XStreamAlias("PRODUCAO-TECNICA")
	private String prodTEc;

	@XStreamImplicit(itemFieldName = "PRODUCAO-BIBLIOGRAFICA")
	private List<ProducaoBibliografica> producaoBibliografica;

	@XStreamImplicit(itemFieldName = "OUTRA-PRODUCAO")
	private List<OutraProducao> outraProd;

	@XStreamImplicit(itemFieldName = "DADOS-COMPLEMENTARES")
	private List<DadosComplementares> dadosComplementares;

	public String getSistemaOrigemXml() {
		return sistemaOrigemXml;
	}

	public void setSistemaOrigemXml(String sistemaOrigemXml) {
		this.sistemaOrigemXml = sistemaOrigemXml;
	}

	public String getNumeroIdentificador() {
		return numeroIdentificador;
	}

	public void setNumeroIdentificador(String numeroIdentificador) {
		this.numeroIdentificador = numeroIdentificador;
	}

	public String getDataAtualizacao() {
		return dataAtualizacao;
	}

	public void setDataAtualizacao(String dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}

	public String getHoraAtualizacao() {
		return horaAtualizacao;
	}

	public void setHoraAtualizacao(String horaAtualizacao) {
		this.horaAtualizacao = horaAtualizacao;
	}

	public List<ProducaoBibliografica> getProducaoBibliografica() {
		return producaoBibliografica;
	}

	public void setProducaoBibliografica(List<ProducaoBibliografica> producaoBibliografica) {
		this.producaoBibliografica = producaoBibliografica;
	}

	public List<OutraProducao> getOutraProd() {
		return outraProd;
	}

	public void setOutraProd(List<OutraProducao> outraProd) {
		this.outraProd = outraProd;
	}

	public List<DadosComplementares> getDadosComplementares() {
		return dadosComplementares;
	}

	public void setDadosComplementares(List<DadosComplementares> dadosComplementares) {
		this.dadosComplementares = dadosComplementares;
	}

}
