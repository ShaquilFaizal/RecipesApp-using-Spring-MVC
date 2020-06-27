package com.shaquilfaizal.RecipesApp.repositories;

import org.springframework.data.repository.CrudRepository;

import com.shaquilfaizal.RecipesApp.domain.Recipe;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {

}
