package com.crystal2033.tacocloud.models;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @project TacoCloud
 * ©Crystal2033
 * @date 11/07/2023
 */
@Data
public class TacoOrder {
    private String deliveryName;
    private String deliveryStreet;
    private String deliveryCity;
    private String deliveryState;
    private String deliveryZip;
    private String ccNumber;
    private String ccExpiration;
    private String ccCVV;
    private final List<Taco> tacos = new ArrayList<>();
    public void addTaco(Taco taco) {
        tacos.add(taco);
    }
}
