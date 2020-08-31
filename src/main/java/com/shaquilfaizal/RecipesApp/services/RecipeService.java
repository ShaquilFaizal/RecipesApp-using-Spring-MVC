package com.shaquilfaizal.RecipesApp.services;

import java.util.Set;

import com.shaquilfaizal.RecipesApp.commands.RecipeCommand;
import com.shaquilfaizal.RecipesApp.domain.Recipe;


public interface RecipeService {

	Set<Recipe> getRecipes();
	
	Recipe findById(Long l);
	
	RecipeCommand saveRecipeCommand(RecipeCommand command);
}
