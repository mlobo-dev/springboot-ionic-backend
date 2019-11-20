package com.wolf.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wolf.domain.Produto;
import com.wolf.repositories.ProdutoRepository;
import com.wolf.service.exception.ObjectNotFoundException;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository repository;

	public Produto buscar(Integer id) {
		Optional<Produto> obj = repository.findById(id);
		if(obj.isPresent()) {
			return obj.get();
		}else {
			throw new ObjectNotFoundException("Id não encontrado");
		}
			
	}
}
