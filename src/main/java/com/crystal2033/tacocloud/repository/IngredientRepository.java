package com.crystal2033.tacocloud.repository;

import com.crystal2033.tacocloud.models.Ingredient;

import java.util.Optional;

/**
 * @project TacoCloud
 * ©Crystal2033
 * @date 22/07/2023
 */
public interface IngredientRepository {
    Iterable<Ingredient> findAll();
    Optional<Ingredient> findById(String id);

    Ingredient save(Ingredient ingredient);
}
