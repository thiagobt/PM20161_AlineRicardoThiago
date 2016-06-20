package com.unirio.ppgi.xstream.model;

import java.io.Serializable;
import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

@XStreamAlias("DADOS-COMPLEMENTARES")
public class DadosComplementares implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 997658633245355286L;
	@XStreamImplicit(itemFieldName = "INFORMACOES-ADICIONAIS-CURSOS")
	private List<InformacoesAdicionaisCursos> informacoesAdicionaisCursos;

	@XStreamImplicit(itemFieldName = "ORIENTACOES-EM-ANDAMENTO")
	private List<OrientacoesEmAndamento> orientacoesEmAndamento;
	
	@XStreamImplicit(itemFieldName = "PARTICIPACAO-EM-BANCA-TRABALHOS-CONCLUSAO")
	private List<PartBancaTrabConclusao> partBancaTrabConc;
	
	
	@XStreamOmitField
	@XStreamAlias("PARTICIPACAO-EM-BANCA-JULGADORA")
	private String partBancaJulg;
	@XStreamOmitField
	@XStreamAlias("PARTICIPACAO-EM-EVENTOS-CONGRESSOS")
	private String partEventos;
	@XStreamOmitField
	@XStreamAlias("INFORMACOES-ADICIONAIS-INSTITUICOES")
	private String infoAdicionaisInst;
	@XStreamOmitField
	@XStreamAlias("FORMACAO-COMPLEMENTAR")
	private String formacaoComplementar;

	public List<InformacoesAdicionaisCursos> getInformacoesAdicionaisCursos() {
		return informacoesAdicionaisCursos;
	}

	public void setInformacoesAdicionaisCursos(List<InformacoesAdicionaisCursos> informacoesAdicionaisCursos) {
		this.informacoesAdicionaisCursos = informacoesAdicionaisCursos;
	}

	public List<OrientacoesEmAndamento> getOrientacoesEmAndamento() {
		return orientacoesEmAndamento;
	}

	public void setOrientacoesEmAndamento(List<OrientacoesEmAndamento> orientacoesEmAndamento) {
		this.orientacoesEmAndamento = orientacoesEmAndamento;
	}
	
	public List<PartBancaTrabConclusao> getPartBancaTrabConc() {
		return partBancaTrabConc;
	}
	
	public void setPartBancaTrabConc(List<PartBancaTrabConclusao> partBancaTrabConc) {
		this.partBancaTrabConc = partBancaTrabConc;
	}

}
