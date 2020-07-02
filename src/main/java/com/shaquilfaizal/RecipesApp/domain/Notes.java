package com.shaquilfaizal.RecipesApp.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
public class Notes {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter
	@Setter
	private Long id;

	@OneToOne
	@Getter
	@Setter
	private Recipe recipe;

	@Lob
	@Getter
	@Setter
	private String recipeNotes;

}
