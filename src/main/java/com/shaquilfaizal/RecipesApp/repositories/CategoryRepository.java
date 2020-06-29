package com.shaquilfaizal.RecipesApp.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.shaquilfaizal.RecipesApp.domain.Category;


public interface CategoryRepository extends CrudRepository<Category, Long> {

	Optional<Category> findByDescription(String description);
}
