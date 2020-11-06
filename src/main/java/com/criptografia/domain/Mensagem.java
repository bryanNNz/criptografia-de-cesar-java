package com.criptografia.domain;

import java.io.Serializable;

public class Mensagem implements Serializable {

	private static final long serialVersionUID = 1L;

	private String texto;
	
	private Integer chave;

	public Mensagem() {
		
	}
	
	public Mensagem(String texto, Integer chave) {
		super();
		this.texto = texto;
		this.chave = chave;
	}

	public String getTextoFormatado() {
		return this.texto.toUpperCase().replace(" ", "#");
	}
	
	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Integer getChave() {
		return chave;
	}

	public void setChave(Integer chave) {
		this.chave = chave;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((chave == null) ? 0 : chave.hashCode());
		result = prime * result + ((texto == null) ? 0 : texto.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Mensagem other = (Mensagem) obj;
		if (chave == null) {
			if (other.chave != null)
				return false;
		} else if (!chave.equals(other.chave))
			return false;
		if (texto == null) {
			if (other.texto != null)
				return false;
		} else if (!texto.equals(other.texto))
			return false;
		return true;
	}
	
}
