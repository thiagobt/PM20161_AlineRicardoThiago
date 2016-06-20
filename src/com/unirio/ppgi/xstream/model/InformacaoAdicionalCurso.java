package com.unirio.ppgi.xstream.model;

import java.io.Serializable;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

@XStreamAlias("INFORMACAO-ADICIONAL-CURSO")
public class InformacaoAdicionalCurso implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3396665259291552988L;
	@XStreamAsAttribute
	@XStreamAlias("CODIGO-CURSO")
	private String codigoCurso;
	@XStreamAsAttribute
	@XStreamAlias("CODIGO-ORGAO")
	private String codigoOrgao;
	@XStreamAsAttribute
	@XStreamAlias("NOME-ORGAO")
	private String nomeOrgao;
	@XStreamAsAttribute
	@XStreamAlias("CODIGO-INSTITUICAO")
	private String codigoInstituicao;
	@XStreamAsAttribute
	@XStreamAlias("NOME-INSTITUICAO")
	private String nomeInstituicao;
	@XStreamAsAttribute
	@XStreamAlias("NOME-GRANDE-AREA-DO-CONHECIMENTO")
	private String nomeGrandeAreDoConheimento;
	@XStreamAsAttribute
	@XStreamAlias("NOME-DA-AREA-DO-CONHECIMENTO")
	private String nomeDaAreDoConheimento;
	@XStreamAsAttribute
	@XStreamAlias("NOME-DA-SUB-AREA-DO-CONHECIMENTO")
	private String nomeDaSubAreDoConheimento;
	@XStreamAsAttribute
	@XStreamAlias("NOME-DA-ESPECIALIDADE")
	private String nomeDaEspcialidad;
	@XStreamAsAttribute
	@XStreamAlias("NIVEL-CURSO")
	private String nivelCurso;

	public String getCodigoCurso() {
		return codigoCurso;
	}

	public void setCodigoCurso(String codigoCurso) {
		this.codigoCurso = codigoCurso;
	}

	public String getCodigoOrgao() {
		return codigoOrgao;
	}

	public void setCodigoOrgao(String codigoOrgao) {
		this.codigoOrgao = codigoOrgao;
	}

	public String getNomeOrgao() {
		return nomeOrgao;
	}

	public void setNomeOrgao(String nomeOrgao) {
		this.nomeOrgao = nomeOrgao;
	}

	public String getCodigoInstituicao() {
		return codigoInstituicao;
	}

	public void setCodigoInstituicao(String codigoInstituicao) {
		this.codigoInstituicao = codigoInstituicao;
	}

	public String getNomeInstituicao() {
		return nomeInstituicao;
	}

	public void setNomeInstituicao(String nomeInstituicao) {
		this.nomeInstituicao = nomeInstituicao;
	}

	public String getNomeGrandeAreDoConheimento() {
		return nomeGrandeAreDoConheimento;
	}

	public void setNomeGrandeAreDoConheimento(String nomeGrandeAreDoConheimento) {
		this.nomeGrandeAreDoConheimento = nomeGrandeAreDoConheimento;
	}

	public String getNomeDaAreDoConheimento() {
		return nomeDaAreDoConheimento;
	}

	public void setNomeDaAreDoConheimento(String nomeDaAreDoConheimento) {
		this.nomeDaAreDoConheimento = nomeDaAreDoConheimento;
	}

	public String getNomeDaSubAreDoConheimento() {
		return nomeDaSubAreDoConheimento;
	}

	public void setNomeDaSubAreDoConheimento(String nomeDaSubAreDoConheimento) {
		this.nomeDaSubAreDoConheimento = nomeDaSubAreDoConheimento;
	}

	public String getNomeDaEspcialidad() {
		return nomeDaEspcialidad;
	}

	public void setNomeDaEspcialidad(String nomeDaEspcialidad) {
		this.nomeDaEspcialidad = nomeDaEspcialidad;
	}

	public String getNivelCurso() {
		return nivelCurso;
	}

	public void setNivelCurso(String nivelCurso) {
		this.nivelCurso = nivelCurso;
	}

}
