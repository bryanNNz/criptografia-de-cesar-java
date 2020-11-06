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

	private static final char[] ALFABETO =  CriptografiaUtil.getAlfabeto();
	
	
	public String criptografar(Mensagem mensagem) throws CriptografiaException {
		mensagemValidation.validarMensagem(mensagem);
		
		char[] texto = mensagem.getTextoFormatado().toCharArray();
		StringBuilder mensagemCriptografada = new StringBuilder("");
		
		for(int i = 0; i < texto.length; i++) {
			if(texto[i] == '#')
				mensagemCriptografada.append('#');
			
			for(int z = 0; z < ALFABETO.length; z++) {
				if(texto[i] == ALFABETO[z])
					mensagemCriptografada.append(ALFABETO[(z + mensagem.getChave()) % 26]);
			}
		}
		
		return mensagemCriptografada.toString().replace("#", " ");
	}
	
	public String descriptografar(Mensagem mensagem) throws CriptografiaException {
		mensagemValidation.validarMensagem(mensagem);
		
		char[] texto = mensagem.getTextoFormatado().toCharArray();
		StringBuilder mensagemCriptografada = new StringBuilder("");
		int modAux = 0;
		
		for(int i = 0; i < texto.length; i++) {
			if(texto[i] == '#')
				mensagemCriptografada.append('#');
			
			for(int z = 0; z < ALFABETO.length; z++) {
				if(texto[i] == ALFABETO[z]) {
					modAux = (z - mensagem.getChave()) % 26;
					mensagemCriptografada.append(ALFABETO[modAux < 0 ? modAux + 26 : modAux]);			
				}
			}
		}
		
		return mensagemCriptografada.toString().replace("#", " ");
	}
	

}
