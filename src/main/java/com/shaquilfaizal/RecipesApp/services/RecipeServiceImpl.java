package com.shaquilfaizal.RecipesApp.services;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shaquilfaizal.RecipesApp.commands.RecipeCommand;
import com.shaquilfaizal.RecipesApp.converters.RecipeCommandToRecipe;
import com.shaquilfaizal.RecipesApp.converters.RecipeToRecipeCommand;
import com.shaquilfaizal.RecipesApp.domain.Recipe;
import com.shaquilfaizal.RecipesApp.repositories.RecipeRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class RecipeServiceImpl implements RecipeService{

	private final RecipeRepository recipeRepository;
    private final RecipeCommandToRecipe recipeCommandToRecipe;
    private final RecipeToRecipeCommand recipeToRecipeCommand;

    public RecipeServiceImpl(RecipeRepository recipeRepository, RecipeCommandToRecipe recipeCommandToRecipe, RecipeToRecipeCommand recipeToRecipeCommand) {
        this.recipeRepository = recipeRepository;
        this.recipeCommandToRecipe = recipeCommandToRecipe;
        this.recipeToRecipeCommand = recipeToRecipeCommand;
    }

	@Override
	public Set<Recipe> getRecipes() {
		log.debug("I'm in the service");
		
		Set<Recipe> recipeSet = new HashSet<>();
		
		recipeRepository.findAll().iterator().forEachRemaining(recipeSet::add);
		return recipeSet;
	}
	
	
	public Recipe findById(Long l) {
		Optional<Recipe> recipeOptional = recipeRepository.findById(l);
		
		if(!recipeOptional.isPresent()) {
			throw new RuntimeException("Recipe Not Found");
		}
		
		return recipeOptional.get();
	}


	
	 @Override
	    @Transactional
	    public RecipeCommand saveRecipeCommand(RecipeCommand command) {
	        Recipe detachedRecipe = recipeCommandToRecipe.convert(command);

	        Recipe savedRecipe = recipeRepository.save(detachedRecipe);
	        log.debug("Saved RecipeId:" + savedRecipe.getId());
	        return recipeToRecipeCommand.convert(savedRecipe);
	    }

}
