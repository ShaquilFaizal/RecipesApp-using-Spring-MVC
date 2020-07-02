package com.shaquilfaizal.RecipesApp.controllers;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shaquilfaizal.RecipesApp.services.RecipeService;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Controller
public class indexController {

	private final RecipeService recipeService;

	public indexController(RecipeService recipeService) {
		super();
		this.recipeService = recipeService;
	}


	@RequestMapping({"","/","/index"})
	public String getIndexPage(Model model) {
		
		log.debug("Getting index page");
		
		model.addAttribute("recipes", recipeService.getRecipes());
		
		return "index";
	}
	
	
}

