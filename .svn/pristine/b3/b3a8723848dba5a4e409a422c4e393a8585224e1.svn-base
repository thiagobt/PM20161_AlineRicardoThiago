package com.unirio.ppgi.xstream.model;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

@XStreamAlias("ARTIGO-PUBLICADO")
public class ArtigoPublicado {

	@XStreamImplicit(itemFieldName = "DADOS-BASICOS-DO-ARTIGO")
	private List<DadosBasicosArtigo> dadosBasicosArtigo;

	@XStreamImplicit(itemFieldName = "DETALHAMENTO-DO-ARTIGO")
	private List<DetalhamentoArtigo> detalhamentoArtigo;

	@XStreamOmitField
	@XStreamAlias("SETORES-DE-ATIVIDADE")
	private String setores;
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
	@XStreamAlias("INFORMACOES-ADICIONAIS")
	private String info;

	public List<DadosBasicosArtigo> getDadosBasicosArtigo() {
		return dadosBasicosArtigo;
	}

	public void setDadosBasicosArtigo(List<DadosBasicosArtigo> dadosBasicosArtigo) {
		this.dadosBasicosArtigo = dadosBasicosArtigo;
	}

	public List<DetalhamentoArtigo> getDetalhamentoArtigo() {
		return detalhamentoArtigo;
	}

	public void setDetalhamentoArtigo(List<DetalhamentoArtigo> detalhamentoArtigo) {
		this.detalhamentoArtigo = detalhamentoArtigo;
	}

}
