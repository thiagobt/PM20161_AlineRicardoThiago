package com.unirio.ppgi.xstream.model;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

@XStreamAlias("OUTRAS-ORIENTACOES-CONCLUIDAS")
public class OutrasOrientacoesConcluidas {

	@XStreamImplicit(itemFieldName = "DADOS-BASICOS-DE-OUTRAS-ORIENTACOES-CONCLUIDAS")
	private List<DadosBasicosConcluidos> dadosBasicos;

	@XStreamImplicit(itemFieldName = "DETALHAMENTO-DE-OUTRAS-ORIENTACOES-CONCLUIDAS")
	private List<DetalhamentoConcluidas> detalhamento;

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

	public List<DadosBasicosConcluidos> getDadosBasicos() {
		return dadosBasicos;
	}

	public void setDadosBasicos(List<DadosBasicosConcluidos> dadosBasicos) {
		this.dadosBasicos = dadosBasicos;
	}

	public List<DetalhamentoConcluidas> getDetalhamento() {
		return detalhamento;
	}

	public void setDetalhamento(List<DetalhamentoConcluidas> detalhamento) {
		this.detalhamento = detalhamento;
	}

}
