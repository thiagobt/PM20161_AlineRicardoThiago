package com.unirio.ppgi.xstream.model;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

@XStreamAlias("PARTICIPACAO-EM-BANCA-DE-GRADUACAO")
public class PartBancaGraduacao {
	
	@XStreamImplicit(itemFieldName = "DADOS-BASICOS-DA-PARTICIPACAO-EM-BANCA-DE-GRADUACAO")
	private List<DadosBasicosBancaGraduacao> dadosBasicos;

	@XStreamOmitField
	@XStreamAlias("DETALHAMENTO-DA-PARTICIPACAO-EM-BANCA-DE-GRADUACAO")
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
	@XStreamOmitField
	@XStreamAlias("PARTICIPANTE-BANCA")
	private String participante;
	
	
	public List<DadosBasicosBancaGraduacao> getDadosBasicos() {
		return dadosBasicos;
	}
	
	public void setDadosBasicos(List<DadosBasicosBancaGraduacao> dadosBasicos) {
		this.dadosBasicos = dadosBasicos;
	}
	
}
