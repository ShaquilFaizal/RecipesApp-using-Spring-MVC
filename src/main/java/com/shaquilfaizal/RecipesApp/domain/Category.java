package com.shaquilfaizal.RecipesApp.domain;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.Getter;
import lombok.Setter;


@Entity
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter @Setter private Long id;
	
	@Getter @Setter private String description;
	
	@ManyToMany(mappedBy = "categories")
	@Getter @Setter private Set<Recipe> recipes;

/*	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<Recipe> getRecipes() {
		return recipes;
	}

	public void setRecipes(Set<Recipe> recipes) {
		this.recipes = recipes;
	}
	*/
	
}
