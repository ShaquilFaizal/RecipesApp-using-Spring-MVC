package com.shaquilfaizal.RecipesApp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shaquilfaizal.RecipesApp.services.RecipeService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class IngredientController {
	
	private final RecipeService recipeService;

	public IngredientController(RecipeService recipeService) {
		this.recipeService = recipeService;
	}
	
	
	@GetMapping
	@RequestMapping("/recipe/{recipeId}/ingredients")
	public String listIngredients(@PathVariable String recipeId, Model model) {
		log.debug("Getting ingredient list for recipe id: " + recipeId);
		
		model.addAttribute("recipe",recipeService.findCommandById(Long.valueOf(recipeId)));
		
		return "recipe/ingredient/list";
	}
	

}