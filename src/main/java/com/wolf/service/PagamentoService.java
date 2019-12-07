package com.wolf.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wolf.domain.Pagamento;
import com.wolf.repositories.PagamentoRepository;
import com.wolf.service.exception.ObjectNotFoundException;

@Service
public class PagamentoService {

	@Autowired
	private PagamentoRepository repo;

	public Pagamento find(Integer id) {
		Optional<Pagamento> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Pagamento.class.getName()));
	}
}