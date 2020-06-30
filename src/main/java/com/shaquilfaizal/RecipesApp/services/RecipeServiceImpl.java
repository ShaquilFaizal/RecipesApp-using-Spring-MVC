package com.shaquilfaizal.RecipesApp.services;

import java.util.HashSet;
import java.util.Set;

import com.shaquilfaizal.RecipesApp.domain.Recipe;
import com.shaquilfaizal.RecipesApp.repositories.RecipeRepository;

public class RecipeServiceImpl implements RecipeService{

	private final RecipeRepository recipeRepository;
	
	
	public RecipeServiceImpl(RecipeRepository recipeRepository) {
		super();
		this.recipeRepository = recipeRepository;
	}


	@Override
	public Set<Recipe> getRecipes() {
		Set<Recipe> recipeSet = new HashSet<>();
		
		recipeRepository.findAll().iterator().forEachRemaining(recipeSet::add);
		return recipeSet;
	}

}
