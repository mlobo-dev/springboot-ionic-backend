package com.wolf.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wolf.domain.Produto;
import com.wolf.repositories.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository repository;

	public Produto buscar(Integer id) {
		Optional<Produto> obj = repository.findById(id);
		return obj.get();
	}
}
