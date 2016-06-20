package com.unirio.ppgi.xstream.helper;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.joda.time.Hours;
import org.joda.time.Minutes;
import org.joda.time.Seconds;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.unirio.ppgi.xstream.constants.Constante;
import com.unirio.ppgi.xstream.model.Curriculo;
import com.unirio.ppgi.xstream.model.Programa;
import com.unirio.ppgi.xstream.model.Programas;
import com.unirio.ppgi.xstream.model.Qualis;

public class Helper {

	// As funcoes "obtem" transformam os xmls em objetos
	// Utilizam a biblioteca xstream, que transforma xml em objeto JAVA
	// A xstream recebe a string de um xml, que entao se transforma para um objeto que esteja mapeado (anotacoes da xstream) 
	
	// Funcao processa o conteudo do xml CONTENTS 
	
	public static Programa obtemContents() {
		String arquivo = lerArquivo(Constante.CONTENTS_XML_NOME);
		if (StringUtils.isBlank(arquivo)) {
			arquivo = lerUrl(Constante.CONTENTS_XML_NOME);
		}
		XStream xs = new XStream();
		xs.processAnnotations(Programa.class);
		Programa programa = (Programa) xs.fromXML(arquivo);

		return programa;
	}

	// Funcao que processa o conteudo do xml QUALIS 
	public static Qualis obtemQualis() {
		String arquivo = lerArquivo(Constante.QUALIS_XML_NOME);
		if (StringUtils.isBlank(arquivo)) {
			arquivo = lerUrl(Constante.QUALIS_XML_NOME);
		}
		XStream xs = new XStream();
		xs.processAnnotations(Qualis.class);
		Qualis qualis = (Qualis) xs.fromXML(arquivo);

		return qualis;
	}

	// Funcao que processa o conteudo do xml PROGRAMAS
	public static Programas obtemProgramas() {
		String arquivo = lerArquivo(Constante.PROGRAMAS_XML_NOME);
		if (StringUtils.isBlank(arquivo)) {
			arquivo = lerUrl(Constante.PROGRAMAS_XML_NOME);
		}
		XStream xs = new XStream();
		xs.processAnnotations(Programas.class);
		Programas programas = (Programas) xs.fromXML(arquivo);

		return programas;
	}

	
	// Funcao que processa o conteudo do xml CURRICULO
	public static Curriculo obtemCurriculoVitae(String cod) {
		String arquivo = "";
		Curriculo curriculo = null;

		String path = Constante.CURRICULO_XML_NOME;
		arquivo = lerArquivo(cod + "/" + path);
		if (StringUtils.isBlank(arquivo)) {
			String extensao = ".zip";
			System.out.println("Baixando arquivo zip da url: " + Constante.CONTENTS_CURRICULO_URL + cod + extensao);
			gravaArquivoDeURL(cod + extensao);
			System.out.println("Lendo arquivo baixado em: " + Constante.DIRETORIO_LOCAL + cod + "/" + path);
			arquivo = lerArquivo(cod + "/" + path);
		}
		XStream xs = new XStream(new DomDriver());
		xs.processAnnotations(Curriculo.class);
		curriculo = (Curriculo) xs.fromXML(arquivo);

		return curriculo;
	}

	// Funcao que le os arquivos com extensao .xml 
	// Utiliza o bufferedreader para ler as linhas do arquivo
	private static String lerArquivo(String path) {

		String diretorio = Constante.DIRETORIO_LOCAL + path;
		String arquivo = "";

		try {
			FileReader arq = new FileReader(diretorio);
			BufferedReader lerArq = new BufferedReader(arq);

			String linha = lerArq.readLine();
			while (linha != null) {
				arquivo += linha;
				linha = lerArq.readLine();
			}
			arq.close();
		} catch (IOException e) {
			System.out.println("%s.\nErro na abertura do arquivo no local: " + diretorio);
		}
		return arquivo;
	}

	// Funcao que le a URL dos arquivos caso nao existam localmente
	public static String lerUrl(String urlStpath) {

		String urlSt = "";
		String arquivo = "";

		if (urlStpath.equalsIgnoreCase(Constante.CONTENTS_XML_NOME)) {
			urlSt = Constante.CONTENTS_CURRICULO_URL + urlStpath;
		}
		if (urlStpath.equalsIgnoreCase(Constante.PROGRAMAS_XML_NOME)
				|| urlStpath.equalsIgnoreCase(Constante.QUALIS_XML_NOME)) {
			urlSt = Constante.PROGRAMAS_QUALIS_URL + urlStpath;
		}

		System.out.println("Iniciando recuperação de arquivo pela url: " + urlSt);
		/** proxy */
		//Properties systemProperties = System.getProperties();
		//systemProperties.put("proxyHost", "proxy1.123456.com.br");
		//systemProperties.put("proxyPort", "9090");
		//systemProperties.put("proxySet", "true");
		/***/
		try {
			URL url = new URL(urlSt);
			BufferedReader lerArq = new BufferedReader(new InputStreamReader(url.openStream()));
			String linha = lerArq.readLine();
			while (linha != null) {
				arquivo += linha;
				linha = lerArq.readLine();
			}
		} catch (IOException e) {
			System.err.printf("Erro na abertura do arquivo pela url: \n", e.getMessage());//%s.
		}
		return arquivo;
	}
	
	// Funcao que insere os parametros de entrada para execucao do programa
	public static Map<String, String> obterParametrosEntrada(String[] args) {
		Map<String, String> parametros = null;
		if (args != null) {
			if (args.length > 0) {
				parametros = new HashMap<String, String>();
				if (args.length > 0 && StringUtils.isNotBlank(args[0])) {
					parametros.put(Constante.PROGRAMA, args[0]);
				}
				if (args.length > 1 && StringUtils.isNotBlank(args[1])) {
					parametros.put(Constante.ANO_INICIO, args[1]);
				}
				if (args.length > 2 && StringUtils.isNotBlank(args[2])) {
					parametros.put(Constante.ANO_FIM, args[2]);
				}
			}
		}
		return parametros;
	}
	
	// Funcao que retorna a diferenca de tempo entre o inicio e fim de execucao - Apenas para controle
	public static void contadorTempo(DateTime inicio, DateTime fim) {
		fim = new DateTime();
		String segundos = Seconds.secondsBetween(inicio, fim).toString().replace("PT", "").replace("S", "");
		String minutos = Minutes.minutesBetween(inicio, fim).toString().replace("PT", "").replace("M", "");
		String horas = Hours.hoursBetween(inicio, fim).toString().replace("PT", "").replace("H", "");
		System.out.println("Sistema executou e instrução em  " + horas + " hora(s), " + minutos + " minuto(s) e "
				+ segundos + " segundo(s).\n");
		System.out.println("Fim   : " + fim + "\n");
	}

	// Funcao para descompactar os arquivos zip de Curriculo
	public static void descompactarArquivosZipCurriculo() {
		final String extension = "zip";
		// Descompactador arquivador = new Descompactador();
		File dir = new File(Constante.DIRETORIO_LOCAL);
		FileFilter filter = null;
		if (extension != null) {
			filter = new FileFilter() {
				public boolean accept(File pathname) {
					return pathname.getAbsolutePath().endsWith(extension);
				}
			};
		}
		if (dir.exists()) {
			for (File file : dir.listFiles(filter)) {
				descompactarArquivo(file.getName());
			}
		}
	}

	// Funcao que extrai arquivos nos diretorios gerados
	public static void descompactarArquivo(String path) {
		final String extension = ".zip";
		Descompactador arquivador = new Descompactador();
		File dir = new File(Constante.DIRETORIO_LOCAL + path);
		if (dir.exists()) {
			arquivador.descompacta(Constante.DIRETORIO_LOCAL + path,
					Constante.DIRETORIO_LOCAL + path.replace(extension, ""));
			System.out.println("Arquivo " + Constante.DIRETORIO_LOCAL + path + " descompactado.");
		}
	}

	// Funcao que realiza o download dos arquivos zip no website
	public static void gravaArquivoDeURL(String path) {

		try {
			URL url = new URL(Constante.CONTENTS_CURRICULO_URL + path);
			InputStream is = url.openStream();
			new File(Constante.DIRETORIO_LOCAL + path.replace(".zip", "")).mkdirs();
			FileOutputStream fos = new FileOutputStream(Constante.DIRETORIO_LOCAL + path);
			int umByte = 0;
			while ((umByte = is.read()) != -1) {
				fos.write(umByte);
			}
			is.close();
			fos.close();
			descompactarArquivo(path);
		} catch (Exception e) {
			System.out.println("Erro ao baixar arquivo zip da url");
		}
	}

}
