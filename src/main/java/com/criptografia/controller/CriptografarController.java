package com.criptografia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.criptografia.domain.Mensagem;
import com.criptografia.exception.CriptografiaException;
import com.criptografia.service.CriptografiaService;

@Controller
@RequestMapping
public class CriptografarController {
	
	@Autowired
	private CriptografiaService service;
	
	@RequestMapping(method = RequestMethod.POST, value = "/criptografar")
	public ResponseEntity<String> criptografar(@RequestBody Mensagem mensagem) throws CriptografiaException {
		String mensagemCriptografada = service.criptografar(mensagem);
		return ResponseEntity.status(HttpStatus.CREATED).body(mensagemCriptografada);
	}
}
