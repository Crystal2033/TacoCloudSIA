package com.crystal2033.tacocloud.models;

import lombok.Data;

/**
 * @project TacoCloud
 * ©Crystal2033
 * @date 11/07/2023
 */
@Data
public class Ingredient {
    private final String id;
    private final String name;
    private final Type type;

    public enum Type
    {
        WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE
    }
}
