package com.criptografia.domain;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Mensagem implements Serializable {

	private static final long serialVersionUID = 1L;

	private String texto;
	
	private Integer chave;

	public String getTextoFormatado() {
		return this.texto.toUpperCase().replace(" ", "#");
	}
	
}
