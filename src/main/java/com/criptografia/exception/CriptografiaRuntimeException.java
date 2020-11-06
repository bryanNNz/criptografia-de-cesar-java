package com.criptografia.exception;

public class CriptografiaRuntimeException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public CriptografiaRuntimeException(String mensagem) {
		super(mensagem);
	}
}
