package com.unirio.ppgi.xstream.service;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.joda.time.DateTime;

import com.unirio.ppgi.xstream.constants.Constante;
import com.unirio.ppgi.xstream.dto.RegistroDTO;
import com.unirio.ppgi.xstream.helper.Helper;
import com.unirio.ppgi.xstream.model.ArtigoPublicado;
import com.unirio.ppgi.xstream.model.ArtigosPublicados;
import com.unirio.ppgi.xstream.model.Curriculo;
import com.unirio.ppgi.xstream.model.DadosBasicosArtigo;
import com.unirio.ppgi.xstream.model.DadosBasicosBancaDoutorado;
import com.unirio.ppgi.xstream.model.DadosBasicosBancaGraduacao;
import com.unirio.ppgi.xstream.model.DadosBasicosBancaMestrado;
import com.unirio.ppgi.xstream.model.DadosBasicosConcluidasDoutorado;
import com.unirio.ppgi.xstream.model.DadosBasicosConcluidasIniciacao;
import com.unirio.ppgi.xstream.model.DadosBasicosConcluidasMestrado;
import com.unirio.ppgi.xstream.model.DadosBasicosConcluidos;
import com.unirio.ppgi.xstream.model.DadosBasicosEmAndamento;
import com.unirio.ppgi.xstream.model.DadosBasicosEmAndamentoDoutorado;
import com.unirio.ppgi.xstream.model.DadosBasicosEmAndamentoGraduacao;
import com.unirio.ppgi.xstream.model.DadosBasicosEmAndamentoMestrado;
import com.unirio.ppgi.xstream.model.DadosBasicosTrabalho;
import com.unirio.ppgi.xstream.model.DadosComplementares;
import com.unirio.ppgi.xstream.model.DetalhamentoArtigo;
import com.unirio.ppgi.xstream.model.DetalhamentoConcluidas;
import com.unirio.ppgi.xstream.model.DetalhamentoEmAndamento;
import com.unirio.ppgi.xstream.model.DetalhamentoTrabalho;
import com.unirio.ppgi.xstream.model.Entry;
import com.unirio.ppgi.xstream.model.InformacaoAdicionalCurso;
import com.unirio.ppgi.xstream.model.InformacoesAdicionaisCursos;
import com.unirio.ppgi.xstream.model.LinhaPesquisa;
import com.unirio.ppgi.xstream.model.OrientacoesConcluidas;
import com.unirio.ppgi.xstream.model.OrientacoesConcluidasDeDoutorado;
import com.unirio.ppgi.xstream.model.OrientacoesConcluidasDeIniciacaoCientifica;
import com.unirio.ppgi.xstream.model.OrientacoesConcluidasDeMestrado;
import com.unirio.ppgi.xstream.model.OrientacoesEmAndamento;
import com.unirio.ppgi.xstream.model.OrientacoesEmAndamentoDeDoutorado;
import com.unirio.ppgi.xstream.model.OrientacoesEmAndamentoDeGraduacao;
import com.unirio.ppgi.xstream.model.OrientacoesEmAndamentoDeMestrado;
import com.unirio.ppgi.xstream.model.OutraProducao;
import com.unirio.ppgi.xstream.model.OutrasOrientacoesConcluidas;
import com.unirio.ppgi.xstream.model.OutrasOrientacoesEmAndamento;
import com.unirio.ppgi.xstream.model.PartBancaDoutorado;
import com.unirio.ppgi.xstream.model.PartBancaGraduacao;
import com.unirio.ppgi.xstream.model.PartBancaMestrado;
import com.unirio.ppgi.xstream.model.PartBancaTrabConclusao;
import com.unirio.ppgi.xstream.model.ProducaoBibliografica;
import com.unirio.ppgi.xstream.model.Professor;
import com.unirio.ppgi.xstream.model.Programa;
import com.unirio.ppgi.xstream.model.Programas;
import com.unirio.ppgi.xstream.model.Qualis;
import com.unirio.ppgi.xstream.model.TrabalhoEventos;
import com.unirio.ppgi.xstream.model.TrabalhosEventos;

public class Servico {
	
	// Classe que contem as funcoes que realizam as operacoes incrementais

	private static DateTime inicio;
	private static DateTime fim;
	private static List<RegistroDTO> registros;
	private static RegistroDTO registro;
	private static Curriculo curriculo = new Curriculo();
	private static Qualis qualis = new Qualis();
	private static Programa programa;
	private static Programas programas;
	private static Map<String, String> parametros;
	private static List<InformacaoAdicionalCurso> cursos;
	private static int anoInicio;
	private static int anoFim;

	
	public static void executaLeituraGravacao(Map<String, String> params) {
		parametros = params;
		inicio = new DateTime();
		System.out.println("Inicio: " + inicio + "\n");
		registros = obterRegistros();
	}

	public static List<RegistroDTO> obterRegistros() {
		return obterUnMarShalXml();
	}

	// Funcao Unmarshal - Xml para Objeto
	// Chama os demais metodos de transformacao XML para objeto
	// Varre os arquivos depois para entao criar a lista RegistrosDTO para gravacao no TXT
	public static List<RegistroDTO> obterUnMarShalXml() {
		initInstancias();
		programas = Helper.obtemProgramas();
		System.out.println("Programa informado: " + parametros.get(Constante.PROGRAMA) + "\n");
		if (programas.getPrograma().get(0).getNome().equalsIgnoreCase(parametros.get(Constante.PROGRAMA))) {
			Helper.descompactarArquivosZipCurriculo();
			programa = Helper.obtemContents();
			for (LinhaPesquisa linha : programa.getLinha()) {
				for (Professor professor : linha.getProfessor()) {
					registro = new RegistroDTO();
					registro.setNomeLinha(linha.getNome());
					registro.setTotalLinhaPesquisa(linha.getProfessor().size());
					registro.setNomeProfessor(professor.getNome());
					curriculo = Helper.obtemCurriculoVitae(professor.getCodigo());
					qualis = Helper.obtemQualis();

					// Obtem artigos publicados em revistas e artigos
					obtemProducaoBibliografica();
					// Orientacoes Em andamento e participacao em bancas
					obtemOrientacoesEmAndamentoPartBancas();
					// Orientacoes concluídas
					obtemOrientacoesConcluidas();

					registros.add(registro);
				}
			}
			System.out.println("\nIniciando gravacao de dados...\n");
			gerarArquivoTxt();
		} else {
			System.out.println("Nao existe programa com o nome informado >>" + parametros.get(Constante.PROGRAMA));
		}
		return registros;

	}

	private static void initInstancias() {
		registros = new ArrayList<RegistroDTO>();
		curriculo = new Curriculo();
		qualis = new Qualis();
		programa = new Programa();
		programas = new Programas();
		cursos = new ArrayList<InformacaoAdicionalCurso>();
		anoInicio=Integer.parseInt(parametros.get(Constante.ANO_INICIO));
		anoFim=Integer.parseInt(parametros.get(Constante.ANO_FIM));
	}
	
	
	// Varre o arquivo de curriculo em busca de artigos e eventos
	private static void obtemProducaoBibliografica() {
		for (ProducaoBibliografica prod : curriculo.getProducaoBibliografica()) {
			obtemArtigosPublicados(prod.getArtigosPublicados());
			obtemTrabalhosEventos(prod.getTrabEventos());

		}
	}

	// Incrementa os atributos de quantidade de artigos de acordo com a classificacao de eventos
	private static void obtemTrabalhosEventos(List<TrabalhosEventos> list) {
		for (TrabalhosEventos trabsevs : list) {
			for (TrabalhoEventos trabsev : trabsevs.getTrabEventos()) {
				for (DadosBasicosTrabalho dba : trabsev.getDadosBasicosTrabalho()) {
					int ano=Integer.parseInt(dba.getAno());
					if(ano>=anoInicio&&ano<=anoFim){
						for (DetalhamentoTrabalho dt : trabsev.getDetalhamentoTrabalho()) {
							for (Entry e : qualis.getEntry()) {
								if (e.getRegex().equalsIgnoreCase(dt.getNomeEvento().toLowerCase())) {
									switch (e.getClassificacao()) {
									case "A1":
										registro.setNumeroArtigoEmEventosA1(registro.getNumeroArtigoEmEventosA1() + 1);
										break;
									case "A2":
										registro.setNumeroArtigoEmEventosA2(registro.getNumeroArtigoEmEventosA2() + 1);
										break;
									case "B1":
										registro.setNumeroArtigoEmEventosB1(registro.getNumeroArtigoEmEventosB1() + 1);
										break;
									case "B2":
										registro.setNumeroArtigoEmEventosB2(registro.getNumeroArtigoEmEventosB2() + 1);
										break;
									case "B3":
										registro.setNumeroArtigoEmEventosB3(registro.getNumeroArtigoEmEventosB3() + 1);
										break;
									case "B4":
										registro.setNumeroArtigoEmEventosB4(registro.getNumeroArtigoEmEventosB4() + 1);
										break;
									case "C":
										registro.setNumeroArtigoEmEventosC(registro.getNumeroArtigoEmEventosC() + 1);
										break;
									case "NC":
										registro.setNumeroArtigoEmEventosNC(registro.getNumeroArtigoEmEventosNC() + 1);
										break;
									default:
										System.out.println(
												"Nao foi encontrada classificacao pro artigo de evento: " + dt.getNomeEvento());
									}
								}
							}
						}
					}
				}
			}
		}
	}

	// Incrementa os atributos de quantidade de artigos publicados de acordo com a classificacao no arquivo
	private static void obtemArtigosPublicados(List<ArtigosPublicados> list) {
		for (ArtigosPublicados arts : list) {
			for (ArtigoPublicado art : arts.getArtigoPublicado()) {
				for (DadosBasicosArtigo dba : art.getDadosBasicosArtigo()) {
					int ano=dba.getAno()==null?0:Integer.parseInt(dba.getAno());
					if(ano>=anoInicio&&ano<=anoFim){
						for (DetalhamentoArtigo da : art.getDetalhamentoArtigo()) {
							for (Entry e : qualis.getEntry()) {
								if (e.getRegex().equalsIgnoreCase(da.getTitulo().toLowerCase())) {
									switch (e.getClassificacao()) {
									case "A1":
										registro.setNumeroArtigoEmRevistaA1(registro.getNumeroArtigoEmRevistaA1() + 1);
										break;
									case "A2":
										registro.setNumeroArtigoEmRevistaA2(registro.getNumeroArtigoEmRevistaA2() + 1);
										break;
									case "B1":
										registro.setNumeroArtigoEmRevistaB1(registro.getNumeroArtigoEmRevistaB1() + 1);
										break;
									case "B2":
										registro.setNumeroArtigoEmRevistaB2(registro.getNumeroArtigoEmRevistaB2() + 1);
										break;
									case "B3":
										registro.setNumeroArtigoEmRevistaB3(registro.getNumeroArtigoEmRevistaB3() + 1);
										break;
									case "B4":
										registro.setNumeroArtigoEmRevistaB4(registro.getNumeroArtigoEmRevistaB4() + 1);
										break;
									case "C":
										registro.setNumeroArtigoEmRevistaC(registro.getNumeroArtigoEmRevistaC() + 1);
										break;
									case "NC":
										registro.setNumeroArtigoEmRevistaNC(registro.getNumeroArtigoEmRevistaNC() + 1);
										break;
									default:
										System.out.println(
												"Não foi encontrada classificação pro artigo de revista: " + da.getTitulo());
									}
								}
							}
						}
					}
				}
			}
		}
	}

	
	// Incrementa os atributos de quantidade de orientacoes em andamento e part. em bancas
	// de acordo com o tipo do curso
	private static void obtemOrientacoesEmAndamentoPartBancas() {
		for (DadosComplementares dados : curriculo.getDadosComplementares()) {
			for (InformacoesAdicionaisCursos info : dados.getInformacoesAdicionaisCursos()) {
				cursos = info.getInformacaoAdicionalCurso();
			}
			// Orientações em andamento
			if (dados.getOrientacoesEmAndamento() != null) {
				for (OrientacoesEmAndamento or : dados.getOrientacoesEmAndamento()) {
					// doutorado
					if (or.getOrientacoesEmAndamentoDeDoutorado() != null) {
						for(OrientacoesEmAndamentoDeDoutorado o:or.getOrientacoesEmAndamentoDeDoutorado()){
							for(DadosBasicosEmAndamentoDoutorado od:o.getDadosBasicos()){
								int ano=od.getAno()==null?0:Integer.parseInt(od.getAno());
								if(ano>=anoInicio&&ano<=anoFim){
								registro.setNumeroOrientacoesDoutoradoEmAndamento(
										or.getOrientacoesEmAndamentoDeDoutorado().size());
								}
							}
						}
					}
					// mestrado
					if (or.getOrientacoesEmAndamentoDeMestrado() != null) {
						for(OrientacoesEmAndamentoDeMestrado o:or.getOrientacoesEmAndamentoDeMestrado()){
							for(DadosBasicosEmAndamentoMestrado od:o.getDadosBasicos()){
								int ano=od.getAno()==null?0:Integer.parseInt(od.getAno());
								if(ano>=anoInicio&&ano<=anoFim){
									registro.setNumeroOrientacoesMestradoEmAndamento(
									or.getOrientacoesEmAndamentoDeMestrado().size());
								}
							}
						}
					}
					// graduacao
					if (or.getOrientacoesEmAndamentoDeGraduacao() != null) {
						for(OrientacoesEmAndamentoDeGraduacao o:or.getOrientacoesEmAndamentoDeGraduacao()){
							for(DadosBasicosEmAndamentoGraduacao od:o.getDadosBasicos()){
								int ano=od.getAno()==null?0:Integer.parseInt(od.getAno());
								if(ano>=anoInicio&&ano<=anoFim){
									registro.setNumeroOrientacoesGraduacaoEmAndamento(
									or.getOrientacoesEmAndamentoDeGraduacao().size());
								}
							}
						}
					}
					if (or.getOutrasOrientacoesEmAndamento() != null) {
						for (OutrasOrientacoesEmAndamento anda : or.getOutrasOrientacoesEmAndamento()) {
							for(OutrasOrientacoesEmAndamento o:or.getOutrasOrientacoesEmAndamento()){
								for(DadosBasicosEmAndamento od:o.getDadosBasicos()){
									int ano=od.getAno()==null?0:Integer.parseInt(od.getAno());
									if(ano>=anoInicio&&ano<=anoFim){
										for (DetalhamentoEmAndamento det : anda.getDetalhamento()) {
											for (InformacaoAdicionalCurso info : cursos) {
												if (info.getCodigoCurso().equalsIgnoreCase(det.getCodigoCurso())
														&& info.getNivelCurso().equalsIgnoreCase("GRADUACAO")) {
													registro.setNumeroOrientacoesGraduacaoEmAndamento(
															registro.getNumeroOrientacoesGraduacaoEmAndamento() + 1);
												}
											}
										}
									}
								}
							}
							

						}
					}
				}
			}
			// participacao em bancas
			obtemParticipacaoBancas(dados.getPartBancaTrabConc());
		}
	}

	// Incrementa os atributos de quantidade de orientacoes concluidas de acordo com o tipo de curso
	private static void obtemOrientacoesConcluidas() {
		for (OutraProducao prod : curriculo.getOutraProd()) {
			// Orientações concluídas
			if (prod.getOrientacoesConcluidas() != null) {
				for (OrientacoesConcluidas or : prod.getOrientacoesConcluidas()) {
					// doutorado
					if (or.getOrientacoesConcluidasDeDoutorado() != null) {
						for(OrientacoesConcluidasDeDoutorado o:or.getOrientacoesConcluidasDeDoutorado()){
							for(DadosBasicosConcluidasDoutorado od:o.getDadosBasicosOrientacoes()){
								int ano=od.getAno()==null?0:Integer.parseInt(od.getAno());
								if(ano>=anoInicio&&ano<=anoFim){
									registro.setNumeroOrientacoesDoutoradoConcluidas(
											or.getOrientacoesConcluidasDeDoutorado().size());
								}
							}
						}
					}
					// mestrado
					if (or.getOrientacoesConcluidasDeMestrado() != null) {
						for(OrientacoesConcluidasDeMestrado o:or.getOrientacoesConcluidasDeMestrado()){
							for(DadosBasicosConcluidasMestrado od:o.getDadosBasicosOrientacoes()){
								int ano=od.getAno()==null?0:Integer.parseInt(od.getAno());
								if(ano>=anoInicio&&ano<=anoFim){
									registro.setNumeroOrientacoesMestradoConcluidas(or.getOrientacoesConcluidasDeMestrado().size());
								}
							}
						}
					}
					// graduacao
					if (or.getOrientacoesConcluidasDeIniciacaoCientifica() != null) {
						for(OrientacoesConcluidasDeIniciacaoCientifica o:or.getOrientacoesConcluidasDeIniciacaoCientifica()){
							for(DadosBasicosConcluidasIniciacao od:o.getDadosBasicosOrientacoes()){
								int ano=od.getAno()==null?0:Integer.parseInt(od.getAno());
								if(ano>=anoInicio&&ano<=anoFim){
									registro.setNumeroOrientacoesGraduacaoConcluidas(
											or.getOrientacoesConcluidasDeIniciacaoCientifica().size());
								}
							}
						}
					}
					if (or.getOutrasOrientacoesConcluidas() != null) {
						for (OutrasOrientacoesConcluidas conc : or.getOutrasOrientacoesConcluidas()) {
							for(DadosBasicosConcluidos od:conc.getDadosBasicos()){
								int ano=od.getAno()==null?0:Integer.parseInt(od.getAno());
								if(ano>=anoInicio&&ano<=anoFim){
									for (DetalhamentoConcluidas det : conc.getDetalhamento()) {
										for (InformacaoAdicionalCurso info : cursos) {
											if (info.getCodigoCurso().equalsIgnoreCase(det.getCodigoCurso())
													&& info.getNivelCurso().equalsIgnoreCase("GRADUACAO")) {
												registro.setNumeroOrientacoesGraduacaoConcluidas(
														registro.getNumeroOrientacoesGraduacaoConcluidas() + 1);
											}
										}
									}
								}
							}
							
						}
					}
				}
			}
		}
	}

	
	// Incrementa os atributos de quantidade part. em bancas de acordo com o tipo de curso
	private static void obtemParticipacaoBancas(List<PartBancaTrabConclusao> parts) {
		if (parts != null) {
			for (PartBancaTrabConclusao part : parts) {
				if (part.getPartBancaDoutorado() != null) {
					for(PartBancaDoutorado o:part.getPartBancaDoutorado()){
						for(DadosBasicosBancaDoutorado od:o.getDadosBasicos()){
							int ano=od.getAno()==null?0:Integer.parseInt(od.getAno());
							if(ano>=anoInicio&&ano<=anoFim){
								registro.setNumeroParticipacoesBancasDoutorado(part.getPartBancaDoutorado().size());
							}
						}
					}
					
				}
				if (part.getPartBancaMestrado() != null) {
					for(PartBancaMestrado o:part.getPartBancaMestrado()){
						for(DadosBasicosBancaMestrado od:o.getDadosBasicos()){
							int ano=od.getAno()==null?0:Integer.parseInt(od.getAno());
							if(ano>=anoInicio&&ano<=anoFim){
								registro.setNumeroParticipacoesBancasMestrado(part.getPartBancaMestrado().size());
							}
						}
					}
				}
				if (part.getPartBancaGraduacao() != null) {
					for(PartBancaGraduacao o:part.getPartBancaGraduacao()){
						for(DadosBasicosBancaGraduacao od:o.getDadosBasicos()){
							int ano=od.getAno()==null?0:Integer.parseInt(od.getAno());
							if(ano>=anoInicio&&ano<=anoFim){
								registro.setNumeroParticipacoesBancasGraduacao(part.getPartBancaGraduacao().size());
							}
						}
					}
				}
			}
		}
	}

	// Gera o arquivo .txt com professor, contagem total e linha de pesquisa
	private static void gerarArquivoTxt() {

		String diretorioCompleto = Constante.DIRETORIO_LOCAL + Constante.NOME_ARQUIVO_FINAL;
		FileWriter arq = null;
		try {
			arq = new FileWriter(diretorioCompleto);
			PrintWriter gravarArq = new PrintWriter(arq);
			int i = 1;
			for (RegistroDTO reg : registros) {
				String arquivo = "";
				arquivo = reg.toString() + "\n";
				if (i == reg.getTotalLinhaPesquisa()) {
					arquivo = arquivo + "Total " + reg.getNomeLinha() + ": " + i + "\r\n";
					i = 0;
				}
				i++;
				gravarArq.printf(arquivo);
				// System.out.println(arquivo);
			}
			arq.close();
		} catch (IOException e) {
			System.out.println("Erro ao criar/salvar o arquivo no diretorio: " + diretorioCompleto);
		}
		Helper.contadorTempo(inicio, fim);
	}

}
