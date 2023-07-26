package com.crystal2033.tacocloud.repository;

import com.crystal2033.tacocloud.models.Ingredient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @project TacoCloud
 * ©Crystal2033
 * @date 22/07/2023
 */
@Repository
public interface IngredientRepository extends CrudRepository<Ingredient, String> {
}
