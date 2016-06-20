package com.unirio.ppgi.xstream.model;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

@XStreamAlias("ORIENTACAO-EM-ANDAMENTO-DE-GRADUACAO")
public class OrientacoesEmAndamentoDeGraduacao {

	@XStreamImplicit(itemFieldName = "DADOS-BASICOS-DA-ORIENTACAO-EM-ANDAMENTO-DE-GRADUACAO")
	private List<DadosBasicosEmAndamentoGraduacao> dadosBasicos;
	
	@XStreamOmitField
	@XStreamAlias("DETALHAMENTO-DA-ORIENTACAO-EM-ANDAMENTO-DE-GRADUACAO")
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
	
	public List<DadosBasicosEmAndamentoGraduacao> getDadosBasicos() {
		return dadosBasicos;
	}
	
	public void setDadosBasicos(List<DadosBasicosEmAndamentoGraduacao> dadosBasicos) {
		this.dadosBasicos = dadosBasicos;
	}

}
