package com.unirio.ppgi.xstream.model;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

@XStreamAlias("TRABALHO-EM-EVENTOS")
public class TrabalhoEventos {

	@XStreamImplicit(itemFieldName = "DADOS-BASICOS-DO-TRABALHO")
	private List<DadosBasicosTrabalho> dadosBasicosTrabalho;

	@XStreamImplicit(itemFieldName = "DETALHAMENTO-DO-TRABALHO")
	private List<DetalhamentoTrabalho> detalhamentoTrabalho;

	@XStreamOmitField
	@XStreamAlias("AUTORES")
	private String autores;
	@XStreamOmitField
	@XStreamAlias("PALAVRAS-CHAVE")
	private String palavrasChave;
	@XStreamOmitField
	@XStreamAlias("AREAS-DO-CONHECIMENTO")
	private String areas;
	@XStreamOmitField
	@XStreamAlias("SETORES-DE-ATIVIDADE")
	private String setores;
	@XStreamOmitField
	@XStreamAlias("INFORMACOES-ADICIONAIS")
	private String info;

	public List<DadosBasicosTrabalho> getDadosBasicosTrabalho() {
		return dadosBasicosTrabalho;
	}

	public void setDadosBasicosTrabalho(List<DadosBasicosTrabalho> dadosBasicosTrabalho) {
		this.dadosBasicosTrabalho = dadosBasicosTrabalho;
	}

	public List<DetalhamentoTrabalho> getDetalhamentoTrabalho() {
		return detalhamentoTrabalho;
	}

	public void setDetalhamentoTrabalho(List<DetalhamentoTrabalho> detalhamentoTrabalho) {
		this.detalhamentoTrabalho = detalhamentoTrabalho;
	}

}
