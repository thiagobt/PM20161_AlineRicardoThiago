package com.unirio.ppgi.xstream.helper;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

// Classe do pacote HELPER para descompactar os arquivos zip
/*http://www.guj.com.br/t/descompactar-arquivos-jar-zip-resolvido/107834*/

public class Descompactador {
	private static final String BARRA_INVERTIDA = "\\";
	private static final int TAMANHO_BUFFER = 512000;
	
	
	// Funcao recebe o caminho do arquivo .zip de origem e monta o destino com arquivo
	public void descompacta(String origem, String destino) {
		if (origem == null || destino == null) {
			return;
		}
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(origem);
		} catch (FileNotFoundException e) {
			System.out.println("Arquivo n�o encontrado para descompactar.");
		}
		ZipInputStream zis = new ZipInputStream(fis);
		FileOutputStream fos = null;
		BufferedOutputStream bos = null;
		ZipEntry ze = null;
		String name = null;
		try {
			while ((ze = zis.getNextEntry()) != null) {
				name = destino + BARRA_INVERTIDA + ze.getName();
				try {
					fos = new FileOutputStream(name);
				} catch (FileNotFoundException exc) {
					montaDiretorio(name);
					fos = new FileOutputStream(name);
				}
				bos = new BufferedOutputStream(fos, TAMANHO_BUFFER);
				int bytes;
				byte buffer[] = new byte[TAMANHO_BUFFER];
				while ((bytes = zis.read(buffer, 0, TAMANHO_BUFFER)) != -1) {
					bos.write(buffer, 0, bytes);
				}
				bos.flush();
				bos.close();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			zis.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// Funcao que monta o diretorio do arquivo onde o curriculo.xml sera armazenado
	private void montaDiretorio(String nome) throws IOException {
		File f;
		StringBuffer sb = new StringBuffer();
		StringTokenizer st = new StringTokenizer(nome, BARRA_INVERTIDA);
		int tokens = st.countTokens() - 1;
		for (int i = 0; i < tokens; i++) {
			sb.append(st.nextToken() + BARRA_INVERTIDA);
		}
		f = new File(sb.toString());
		f.mkdirs();
	}
}
