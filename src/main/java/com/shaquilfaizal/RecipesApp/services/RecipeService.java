package com.shaquilfaizal.RecipesApp.services;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.shaquilfaizal.RecipesApp.domain.Recipe;


public interface RecipeService {

	Set<Recipe> getRecipes();
}
