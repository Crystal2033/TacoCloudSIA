package com.crystal2033.tacocloud.models;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @project TacoCloud
 * ©Crystal2033
 * @date 11/07/2023
 */
@Data
public class Taco {

    private Long id;

    private Date createdAt = new Date();
    @NotNull
    @Size(min = 5, message = "Name must be at least 5 characters long")
    private String name;

    @NotNull
    @Size(min = 1, message ="You must choose at least 1 ingredient")
    private List<Ingredient> ingredients;

}
