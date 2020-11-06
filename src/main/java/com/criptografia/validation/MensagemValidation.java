package com.criptografia.validation;

import org.springframework.stereotype.Component;

import com.criptografia.domain.Mensagem;
import com.criptografia.exception.CriptografiaException;

@Component
public class MensagemValidation {
	public void validarMensagem(Mensagem mensagem) throws CriptografiaException {
		if(mensagem.getChave() == null || mensagem.getChave() <= 0)
			throw new CriptografiaException("CHAVE INVALIDA");
		
		if(mensagem.getTexto() == null || mensagem.getTexto().equals(""))
			throw new CriptografiaException("TEXTO INVALIDO");
	}
}
