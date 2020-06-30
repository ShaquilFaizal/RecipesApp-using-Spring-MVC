package com.shaquilfaizal.RecipesApp.controllers;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shaquilfaizal.RecipesApp.services.RecipeService;


@Controller
public class indexController {

	private final RecipeService recipeService;

	public indexController(RecipeService recipeService) {
		super();
		this.recipeService = recipeService;
	}


	@RequestMapping({"","/","/index"})
	public String getIndexPage(Model model) {
		
		model.addAttribute("recipes", recipeService.getRecipes());
		
		return "index";
	}
	
	
}

