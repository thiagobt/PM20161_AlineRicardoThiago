/* PM 2016.1 - Trabalho final do curso*/
/* Criado por Aline Guedes, Ricardo Conte, Thiago Brito */
/* Leia o Readme antes de realizar alteracoes */

package com.unirio.ppgi.xstream.main;

import java.util.Map;

import com.unirio.ppgi.xstream.helper.Helper;
import com.unirio.ppgi.xstream.service.Servico;


public class Inicia {
	
// Esta classe e utilizada para iniciar o programa com os parametros necessarios
	
	public static void main(String[] args) {
		/* atributos esperados */
		//args = new String[3];
		//args[0] = "PPGI-UNIRIO";
		//args[1] = "0";
		//args[2] = "2016";
		/* ./atributos */

		Map<String, String> params = Helper.obterParametrosEntrada(args);

		Servico.executaLeituraGravacao(params);

	}

}
