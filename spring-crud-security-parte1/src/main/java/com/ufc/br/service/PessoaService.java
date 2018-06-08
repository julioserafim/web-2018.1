package com.ufc.br.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ufc.br.model.Pessoa;
import com.ufc.br.repository.PessoaRepository;
import com.ufc.br.util.AulaFileUtils;

@Service
public class PessoaService {
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	public void salvarPessoa(Pessoa pessoa, MultipartFile imagem) {
		pessoa.setSenha(new BCryptPasswordEncoder().encode(pessoa.getSenha()));
		
		String caminho = "images/" + pessoa.getNome() + ".png";
		AulaFileUtils.salvarImagem(caminho,imagem);
		
		pessoaRepository.save(pessoa);
		
	}

	public List<Pessoa> listarPessoas() {
		return pessoaRepository.findAll();
	}

	public Pessoa buscarPorId(Long id) {
		return pessoaRepository.getOne(id);
		
	}

	public void excluirPorId(Long id) {
		pessoaRepository.deleteById(id);
		
	}

}
