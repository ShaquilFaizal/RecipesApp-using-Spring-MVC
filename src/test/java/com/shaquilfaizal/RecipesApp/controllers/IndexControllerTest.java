package com.shaquilfaizal.RecipesApp.controllers;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import com.shaquilfaizal.RecipesApp.services.RecipeService;

class IndexControllerTest {

	
	@Mock
	RecipeService recipeService;
	
	@Mock
	Model model;
	
	indexController controller;
	
	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		
		controller = new indexController(recipeService);
	}


	@Test
	void testGetIndexPage() {
		String viewName= controller.getIndexPage(model);
		
		assertEquals("index", viewName);
		verify(recipeService, times(1)).getRecipes();
		verify(model, times(1)).addAttribute(eq("recipes"), anySet());
	}

}
