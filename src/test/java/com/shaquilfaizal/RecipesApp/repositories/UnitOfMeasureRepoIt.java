package com.shaquilfaizal.RecipesApp.repositories;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.shaquilfaizal.RecipesApp.domain.UnitOfMeasure;

//@ExtendWith(value = { Class<UnitOfMeasureRepoIt })
@DataJpaTest
class UnitOfMeasureRepoIt {

	@Autowired
	UnitOfMeasureRepository unitOfMeasureRepository;
	
	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	public void findByDescription() throws Exception{
		Optional<UnitOfMeasure>  uomOptional = unitOfMeasureRepository.findByDescription("Teaspoon");	
		assertEquals("Teaspoon",uomOptional.get().getDescription());
	}
	
	@Test
	public void findByDescriptionCup() throws Exception{
		Optional<UnitOfMeasure>  uomOptional = unitOfMeasureRepository.findByDescription("Cup");	
		assertEquals("Cup",uomOptional.get().getDescription());
	}
}
