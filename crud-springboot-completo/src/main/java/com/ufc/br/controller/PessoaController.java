package com.ufc.br.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ufc.br.model.Pessoa;
import com.ufc.br.service.PessoaService;

@Controller
@RequestMapping("/pessoa")
public class PessoaController {
	
	@Autowired
	private PessoaService pessoaService;
	
	@RequestMapping("/formulario")
	public ModelAndView formularioPessoa() {
		ModelAndView mv = new ModelAndView("formulario");
		mv.addObject("pessoa", new Pessoa());
		return mv;
	}
	
	@PostMapping("/salvar")
	public ModelAndView salvarPessoa(Pessoa pessoa) {
		pessoaService.adicionarPessoa(pessoa);
		
		ModelAndView mv = new ModelAndView("redirect:/pessoa/listar");
		
		return mv;
	}
	
	@GetMapping("/listar")
	public ModelAndView listarPessoa() {
		List<Pessoa> pessoas = pessoaService.retornarTodasAsPessoas();
		ModelAndView mv = new ModelAndView("pagina-listagem");
		
		mv.addObject("todasAsPessoas", pessoas);
		
		return mv;
	}
	
	@RequestMapping("{id}")
	public ModelAndView atualizarPessoa(@PathVariable Long id) {
		Pessoa pessoa = pessoaService.buscarPorId(id);
		ModelAndView mv = new ModelAndView("formulario");
		mv.addObject("pessoa", pessoa);
		
		return mv;
	}
	
	@RequestMapping("/excluir/{id}")
	public ModelAndView excluirPessoa(@PathVariable Long id) {
		pessoaService.removerPessoa(id);
		ModelAndView mv = new ModelAndView("redirect:/pessoa/listar");
		return mv;
	}
	
	
	
	
	
	
	
	
	

}
