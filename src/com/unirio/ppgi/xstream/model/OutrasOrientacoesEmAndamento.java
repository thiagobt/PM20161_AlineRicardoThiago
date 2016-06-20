package com.unirio.ppgi.xstream.model;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

@XStreamAlias("OUTRAS-ORIENTACOES-EM-ANDAMENTO")
public class OutrasOrientacoesEmAndamento {

	@XStreamImplicit(itemFieldName = "DADOS-BASICOS-DE-OUTRAS-ORIENTACOES-EM-ANDAMENTO")
	private List<DadosBasicosEmAndamento> dadosBasicos;

	@XStreamImplicit(itemFieldName = "DETALHAMENTO-DE-OUTRAS-ORIENTACOES-EM-ANDAMENTO")
	private List<DetalhamentoEmAndamento> detalhamento;

	@XStreamOmitField
	@XStreamAlias("INFORMACOES-ADICIONAIS")
	private String info;
	@XStreamOmitField
	@XStreamAlias("AREAS-DO-CONHECIMENTO")
	private String areas;
	@XStreamOmitField
	@XStreamAlias("PALAVRAS-CHAVE")
	private String palavras;
	@XStreamOmitField
	@XStreamAlias("SETORES-DE-ATIVIDADE")
	private String setores;

	public List<DadosBasicosEmAndamento> getDadosBasicos() {
		return dadosBasicos;
	}

	public void setDadosBasicos(List<DadosBasicosEmAndamento> dadosBasicos) {
		this.dadosBasicos = dadosBasicos;
	}

	public List<DetalhamentoEmAndamento> getDetalhamento() {
		return detalhamento;
	}

	public void setDetalhamento(List<DetalhamentoEmAndamento> detalhamento) {
		this.detalhamento = detalhamento;
	}

}
