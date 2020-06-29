package com.shaquilfaizal.RecipesApp.controllers;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shaquilfaizal.RecipesApp.domain.Category;
import com.shaquilfaizal.RecipesApp.domain.UnitOfMeasure;
import com.shaquilfaizal.RecipesApp.repositories.CategoryRepository;
import com.shaquilfaizal.RecipesApp.repositories.UnitOfMeasureRepository;

@Controller
public class indexController {

	private CategoryRepository categoryRepository;
	private UnitOfMeasureRepository unitOfMeasureRepository;
	

	public indexController(CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
		
		this.categoryRepository = categoryRepository;
		this.unitOfMeasureRepository = unitOfMeasureRepository;
	}

	


	@RequestMapping({"","/","/index"})
	public String getIndexPage() {
		
		Optional<Category> categoryOptional = categoryRepository.findByDescription("American");
		Optional<UnitOfMeasure> unitOfMeasureOptional = unitOfMeasureRepository.findByDescription("Tablespoon");
		
		System.out.println("cat id is: " +categoryOptional.get().getId());
		System.out.println("uom id is: " +unitOfMeasureOptional.get().getId());
		
		
		return "index";
	}
	
	
}

