package com.unirio.ppgi.xstream.model;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

@XStreamAlias("ORIENTACOES-CONCLUIDAS")
public class OrientacoesConcluidas {

	@XStreamImplicit(itemFieldName = "ORIENTACOES-CONCLUIDAS-PARA-MESTRADO")
	private List<OrientacoesConcluidasDeMestrado> orientacoesConcluidasDeMestrado;

	@XStreamImplicit(itemFieldName = "ORIENTACOES-CONCLUIDAS-PARA-DOUTORADO")
	private List<OrientacoesConcluidasDeDoutorado> orientacoesConcluidasDeDoutorado;

	@XStreamImplicit(itemFieldName = "OUTRAS-ORIENTACOES-CONCLUIDAS")
	private List<OutrasOrientacoesConcluidas> outrasOrientacoesConcluidas;

	@XStreamImplicit(itemFieldName = "ORIENTACAO-CONCLUIDAS-PARA-INICIACAO-CIENTIFICA")
	private List<OrientacoesConcluidasDeIniciacaoCientifica> orientacoesConcluidasDeIniciacaoCientifica;

	@XStreamOmitField
	@XStreamAlias("ORIENTACOES-CONCLUIDAS-PARA-POS-DOUTORADO")
	private String orientacoesConcluidasParaPosDoutorado;

	public List<OrientacoesConcluidasDeMestrado> getOrientacoesConcluidasDeMestrado() {
		return orientacoesConcluidasDeMestrado;
	}

	public void setOrientacoesConcluidasDeMestrado(
			List<OrientacoesConcluidasDeMestrado> orientacoesConcluidasDeMestrado) {
		this.orientacoesConcluidasDeMestrado = orientacoesConcluidasDeMestrado;
	}

	public List<OrientacoesConcluidasDeDoutorado> getOrientacoesConcluidasDeDoutorado() {
		return orientacoesConcluidasDeDoutorado;
	}

	public void setOrientacoesConcluidasDeDoutorado(
			List<OrientacoesConcluidasDeDoutorado> orientacoesConcluidasDeDoutorado) {
		this.orientacoesConcluidasDeDoutorado = orientacoesConcluidasDeDoutorado;
	}

	public List<OutrasOrientacoesConcluidas> getOutrasOrientacoesConcluidas() {
		return outrasOrientacoesConcluidas;
	}

	public void setOutrasOrientacoesConcluidas(List<OutrasOrientacoesConcluidas> outrasOrientacoesConcluidas) {
		this.outrasOrientacoesConcluidas = outrasOrientacoesConcluidas;
	}

	public List<OrientacoesConcluidasDeIniciacaoCientifica> getOrientacoesConcluidasDeIniciacaoCientifica() {
		return orientacoesConcluidasDeIniciacaoCientifica;
	}

	public void setOrientacoesConcluidasDeIniciacaoCientifica(
			List<OrientacoesConcluidasDeIniciacaoCientifica> orientacoesConcluidasDeIniciacaoCientifica) {
		this.orientacoesConcluidasDeIniciacaoCientifica = orientacoesConcluidasDeIniciacaoCientifica;
	}

}
