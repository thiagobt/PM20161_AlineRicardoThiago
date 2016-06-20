package com.unirio.ppgi.xstream.model;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

@XStreamAlias("PARTICIPACAO-EM-BANCA-TRABALHOS-CONCLUSAO")
public class PartBancaTrabConclusao {
	
	
	@XStreamImplicit(itemFieldName = "PARTICIPACAO-EM-BANCA-DE-MESTRADO")
	private List<PartBancaMestrado> partBancaMestrado;
	
	@XStreamImplicit(itemFieldName = "PARTICIPACAO-EM-BANCA-DE-DOUTORADO")
	private List<PartBancaDoutorado> partBancaDoutorado;
	
	@XStreamImplicit(itemFieldName = "PARTICIPACAO-EM-BANCA-DE-GRADUACAO")
	private List<PartBancaGraduacao> partBancaGraduacao;
	
	@XStreamOmitField
	@XStreamAlias("PARTICIPACAO-EM-BANCA-DE-EXAME-QUALIFICACAO")
	private String participacaoBancaExame;
	@XStreamOmitField
	@XStreamAlias("PARTICIPACAO-EM-BANCA-DE-APERFEICOAMENTO-ESPECIALIZACAO")
	private String participacaoBancaAperfeicoamento;

	public List<PartBancaMestrado> getPartBancaMestrado() {
		return partBancaMestrado;
	}

	public void setPartBancaMestrado(List<PartBancaMestrado> partBancaMestrado) {
		this.partBancaMestrado = partBancaMestrado;
	}

	public List<PartBancaDoutorado> getPartBancaDoutorado() {
		return partBancaDoutorado;
	}

	public void setPartBancaDoutorado(List<PartBancaDoutorado> partBancaDoutorado) {
		this.partBancaDoutorado = partBancaDoutorado;
	}

	public List<PartBancaGraduacao> getPartBancaGraduacao() {
		return partBancaGraduacao;
	}

	public void setPartBancaGraduacao(List<PartBancaGraduacao> partBancaGraduacao) {
		this.partBancaGraduacao = partBancaGraduacao;
	}
	
	
	

}
