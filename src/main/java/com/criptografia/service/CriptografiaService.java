package com.criptografia.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.criptografia.domain.Mensagem;
import com.criptografia.exception.CriptografiaException;
import com.criptografia.util.CriptografiaUtil;
import com.criptografia.validation.MensagemValidation;

@Service
public class CriptografiaService {
	@Autowired
	private MensagemValidation mensagemValidation;

	private static final String ALFABETO =  CriptografiaUtil.getAlfabeto();
	
	
	public String criptografar(Mensagem mensagem) throws CriptografiaException {
		mensagemValidation.validarMensagem(mensagem);
		
		char[] texto = mensagem.getTextoFormatado().toCharArray();
		StringBuilder mensagemCriptografada = new StringBuilder("");
		int index = 0;
		
		for(char c : texto) {
			if(c == '#') {
				mensagemCriptografada.append('#');
				continue;
			}
			
			index = ALFABETO.indexOf(c);
			mensagemCriptografada.append(ALFABETO.charAt((index + mensagem.getChave()) % 26));
			
		}
		
		return mensagemCriptografada.toString().replace("#", " ");
	}
	
	public String descriptografar(Mensagem mensagem) throws CriptografiaException {
		mensagemValidation.validarMensagem(mensagem);
		
		char[] texto = mensagem.getTextoFormatado().toCharArray();
		StringBuilder mensagemCriptografada = new StringBuilder("");
		int modAux = 0;
		int index = 0;
		
		for(char c : texto) {
			if(c == '#') {
				mensagemCriptografada.append('#');
				continue;
			}
			
			index = ALFABETO.indexOf(c);
			modAux = (index - mensagem.getChave()) % 26;
			mensagemCriptografada.append(ALFABETO.charAt(modAux < 0 ? modAux + 26 : modAux));
		}
		
		return mensagemCriptografada.toString().replace("#", " ");
	}
	

}
