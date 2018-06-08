package com.ufc.br.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
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
	public ModelAndView salvarPessoa(Pessoa pessoa, @RequestParam(value= "imagem") MultipartFile imagem) {
		pessoaService.salvarPessoa(pessoa,imagem);
		
		ModelAndView mv = new ModelAndView("formulario");
		mv.addObject("mensagem", "Usuário salvo com sucesso!");
		
		
		return mv;
		
	}
	
	@GetMapping("/listar")
	public ModelAndView listarPessoa() {
	  List<Pessoa> pessoas = pessoaService.listarPessoas();
	  ModelAndView mv = new ModelAndView("pagina-listagem");
	  mv.addObject("todasAsPessoas", pessoas);
	  
	  return mv;
	}
	
	@RequestMapping("/atualizar/{id}")
	public ModelAndView atualizarPessoa(@PathVariable Long id) {
		Pessoa pessoa = pessoaService.buscarPorId(id);
		ModelAndView mv = new ModelAndView("formulario");
		mv.addObject("pessoa", pessoa);
		return mv;
	}
	
	@RequestMapping("/excluir/{id}")
	public ModelAndView excluirPessoa(@PathVariable Long id) {
		pessoaService.excluirPorId(id);
		ModelAndView mv = new ModelAndView("redirect:/pessoa/listar");
		return mv;
	}
	
	
	@RequestMapping("/logar")
	public ModelAndView logar() {
		ModelAndView mv = new ModelAndView("login");
		return mv;
	}
	
	
	
	
	
	
	
	
	
	
	

}
