package com.shaquilfaizal.RecipesApp.services;

import static org.junit.jupiter.api.Assertions.*;


import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Matchers.*;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.shaquilfaizal.RecipesApp.commands.RecipeCommand;
import com.shaquilfaizal.RecipesApp.converters.RecipeCommandToRecipe;
import com.shaquilfaizal.RecipesApp.converters.RecipeToRecipeCommand;
import com.shaquilfaizal.RecipesApp.domain.Recipe;
import com.shaquilfaizal.RecipesApp.repositories.RecipeRepository;

class RecipeServiceImplTest {

	
	RecipeServiceImpl recipeService;
	
	@Mock
	RecipeRepository recipeRepository;
	
	@Mock
	RecipeToRecipeCommand recipeToRecipeCommand;
	
	@Mock
	RecipeCommandToRecipe recipeCommandToRecipe;
	
	
	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		
		recipeService = new RecipeServiceImpl(recipeRepository,recipeCommandToRecipe,recipeToRecipeCommand);
		
	}

	
	@Test
	public void getRecipeByIdTest() throws Exception{
		 Recipe recipe = new Recipe();
	        recipe.setId(1L);
	        Optional<Recipe> recipeOptional = Optional.of(recipe);

	        when(recipeRepository.findById(Matchers.anyLong())).thenReturn(recipeOptional);

	        Recipe recipeReturned = recipeService.findById(1L);

	        assertNotNull(recipeReturned, "Null recipe returned");
	        verify(recipeRepository, times(1)).findById(Matchers.anyLong());
	        verify(recipeRepository, never()).findAll();
	}
	
	
	@Test
    public void getRecipeCoomandByIdTest() throws Exception {
        Recipe recipe = new Recipe();
        recipe.setId(1L);
        Optional<Recipe> recipeOptional = Optional.of(recipe);

        when(recipeRepository.findById(Matchers.anyLong())).thenReturn(recipeOptional);

        RecipeCommand recipeCommand = new RecipeCommand();
        recipeCommand.setId(1L);

        when(recipeToRecipeCommand.convert(any())).thenReturn(recipeCommand);

        RecipeCommand commandById = recipeService.findCommandById(1L);

        assertNotNull(commandById, "Null recipe returned");
        verify(recipeRepository, times(1)).findById(anyLong());
        verify(recipeRepository, never()).findAll();
    }
	
	@Test
	void testGetRecipes() throws Exception {
		
		Recipe recipe = new Recipe();
		HashSet recipesData = new HashSet<>();
		recipesData.add(recipe);
		
		when(recipeService.getRecipes()).thenReturn(recipesData);		
		
		Set<Recipe> recipes = recipeService.getRecipes();
		
		assertEquals(recipes.size(), 1);
		verify(recipeRepository,times(1)).findAll();
		verify(recipeRepository, never()).findById(Mockito.anyLong());
	}

	public void testDeleteById() throws Exception {
		
		Long idToDelete = Long.valueOf(2l);
		recipeService.deleteById(idToDelete);
		
		verify(recipeRepository, times(1)).deleteById(anyLong());
	}
}
