package com.unirio.ppgi.xstream.model;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

@XStreamAlias("ORIENTACAO-EM-ANDAMENTO-DE-MESTRADO")
public class OrientacoesConcluidasDeMestrado {

	@XStreamImplicit(itemFieldName = "DADOS-BASICOS-DE-ORIENTACOES-CONCLUIDAS-PARA-MESTRADO")
	private List<DadosBasicosConcluidasMestrado> dadosBasicosOrientacoes;

	@XStreamOmitField
	@XStreamAlias("DETALHAMENTO-DE-ORIENTACOES-CONCLUIDAS-PARA-MESTRADO")
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

	public List<DadosBasicosConcluidasMestrado> getDadosBasicosOrientacoes() {
		return dadosBasicosOrientacoes;
	}

	public void setDadosBasicosOrientacoes(List<DadosBasicosConcluidasMestrado> dadosBasicosOrientacoes) {
		this.dadosBasicosOrientacoes = dadosBasicosOrientacoes;
	}

}
