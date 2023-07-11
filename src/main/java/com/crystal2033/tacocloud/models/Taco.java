package com.crystal2033.tacocloud.models;

import lombok.Data;

import java.util.List;

/**
 * @project TacoCloud
 * ©Crystal2033
 * @date 11/07/2023
 */
@Data
public class Taco {
    private String name;
    private List<Ingredient> ingredients;

}
