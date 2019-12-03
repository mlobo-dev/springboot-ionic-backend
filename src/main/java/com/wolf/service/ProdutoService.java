package com.wolf.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.wolf.domain.Categoria;
import com.wolf.domain.Produto;
import com.wolf.repositories.CategoriaRepository;
import com.wolf.repositories.ProdutoRepository;
import com.wolf.service.exception.ObjectNotFoundException;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository repository;

	@Autowired
	CategoriaRepository categoriaRepository;

	public Produto buscar(Integer id) {
		Optional<Produto> obj = repository.findById(id);
		if (obj.isPresent()) {
			return obj.get();
		} else {
			throw new ObjectNotFoundException("Id não encontrado");
		}
	}

	/*
	 * public Page<Produto> search(String nome, List<Integer> ids, Integer page,
	 * Integer linesPerPage, String orderBy, String direction) { PageRequest
	 * pageRequest = PageRequest.of(page, linesPerPage,
	 * Direction.valueOf(direction), orderBy); List<Categoria> categorias =
	 * categoriaRepository.findAllById(ids); return repository.search(nome,
	 * categorias, pageRequest); }
	 */

	public Page<Produto> search(String nome, List<Integer> ids, Integer page, Integer linesPerPage, String orderBy,
			String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		List<Categoria> categorias = categoriaRepository.findAllById(ids);
		return repository.findDisctinctByNomeContainingAndCategoriasIn(nome, categorias, pageRequest);
	}
}
