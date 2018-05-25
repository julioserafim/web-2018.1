package com.ufc.br.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ufc.br.model.Pessoa;
import com.ufc.br.repository.PessoaRepository;

@Controller
@RequestMapping("/pessoa")
public class PessoaController {
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	@RequestMapping("/nova")
	public String cadastroForm() {
		return "formulario";
	}
	
	@PostMapping("/salvar")
	public String salvar(Pessoa pessoa) {
		pessoaRepository.save(pessoa);
		
		System.out.println("Pessoa: " + pessoa.getNome());
		
		
		return "formulario";
	}

}
