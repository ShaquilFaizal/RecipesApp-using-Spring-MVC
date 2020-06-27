package com.shaquilfaizal.RecipesApp.repositories;

import org.springframework.data.repository.CrudRepository;

import com.shaquilfaizal.RecipesApp.domain.Category;

public interface CategoryRepository extends CrudRepository<Category, Long> {

}
