package com.unirio.ppgi.xstream.model;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

@XStreamAlias("ORIENTACAO-CONCLUIDAS-PARA-INICIACAO-CIENTIFICA")
public class OrientacoesConcluidasDeIniciacaoCientifica {

	@XStreamImplicit(itemFieldName = "DADOS-BASICOS-DE-ORIENTACOES-CONCLUIDAS-PARA-INICIACAO-CIENTIFICA")
	private List<DadosBasicosConcluidasIniciacao> dadosBasicosOrientacoes;

	@XStreamOmitField
	@XStreamAlias("DETALHAMENTO-DE-ORIENTACOES-CONCLUIDAS-PARA-DOUTORADO")
	private String detalhamento;
	@XStreamOmitField
	@XStreamAlias("INFORMACOES-ADICIONAIS")
	private String info;
	@XStreamOmitField
	@XStreamAlias("PALAVRAS-CHAVE")
	private String palavras;
	@XStreamOmitField
	@XStreamAlias("AREAS-DO-CONHECIMENTO")
	private String areas;
	@XStreamOmitField
	@XStreamAlias("SETORES-DE-ATIVIDADE")
	private String setores;

	public List<DadosBasicosConcluidasIniciacao> getDadosBasicosOrientacoes() {
		return dadosBasicosOrientacoes;
	}

	public void setDadosBasicosOrientacoes(List<DadosBasicosConcluidasIniciacao> dadosBasicosOrientacoes) {
		this.dadosBasicosOrientacoes = dadosBasicosOrientacoes;
	}

}
