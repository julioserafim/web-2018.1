package com.ufc.br.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ufc.br.model.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long>{

}
