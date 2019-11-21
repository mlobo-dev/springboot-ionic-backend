package com.wolf;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.wolf.domain.Categoria;
import com.wolf.repositories.CategoriaRepository;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class CategoriaRepositoryTest {
	@Autowired
	private CategoriaRepository repository;
	
	@Test
	public void createShouldPersistData() {
		Categoria cat = new Categoria(1, "Moda");
		this.repository.save(cat);
		Assertions.assertThat(cat.getId()).isNotNull();
		Assertions.assertThat(cat.getNome()).isEqualTo("Moda");
	}
}
