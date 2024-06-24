package com.danilo.workshopmongo.resource.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class URL {
	
//	Classe para decodificar os textos
	public static String decodeParam(String text) {
		
		try {

//			"UTF-8" é o padrão de codificação da WEB
			return URLDecoder.decode(text, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			return "";
		} 
	}

}
