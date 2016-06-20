package com.unirio.ppgi.xstream.model;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

@XStreamAlias("PARTICIPACAO-EM-BANCA-DE-DOUTORADO")
public class PartBancaDoutorado {

	@XStreamImplicit(itemFieldName = "DADOS-BASICOS-DA-PARTICIPACAO-EM-BANCA-DE-DOUTORADO")
	private List<DadosBasicosBancaDoutorado> dadosBasicos;
	
	@XStreamOmitField
	@XStreamAlias("DETALHAMENTO-DA-PARTICIPACAO-EM-BANCA-DE-DOUTORADO")
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
	
	public List<DadosBasicosBancaDoutorado> getDadosBasicos() {
		return dadosBasicos;
	}
	
	public void setDadosBasicos(List<DadosBasicosBancaDoutorado> dadosBasicos) {
		this.dadosBasicos = dadosBasicos;
	}
	

}
