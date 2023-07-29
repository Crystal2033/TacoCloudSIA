//package com.crystal2033.tacocloud.converters;
//
//import com.crystal2033.tacocloud.models.Ingredient;
//import com.crystal2033.tacocloud.repository.IngredientRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.core.convert.converter.Converter;
//import org.springframework.stereotype.Component;
//
//
///**
// * @project TacoCloud
// * ©Crystal2033
// * @date 14/07/2023
// */
//
//@Component
//public class IngredientByIdConverter implements Converter<String, Ingredient> {
//    private final IngredientRepository ingredientRepository;
//
//    public IngredientByIdConverter(IngredientRepository ingredientRepository) {
//        this.ingredientRepository = ingredientRepository;
//    }
//
//    @Override
//    public Ingredient convert(String id) {
//        return ingredientRepository.findById(id).orElse(null);
//    }
//}
