package com.shaquilfaizal.RecipesApp.services;

import java.util.Set;

import com.shaquilfaizal.RecipesApp.domain.Recipe;

public interface RecipeService {

	Set<Recipe> getRecipes();
}