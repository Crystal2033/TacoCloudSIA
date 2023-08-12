package com.crystal2033.tacocloud.restclient;

import com.crystal2033.tacocloud.models.Ingredient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

/**
 * @project TacoCloud
 * ©Crystal2033
 * @date 11/08/2023
 */
@Controller
@Slf4j
@RequestMapping("/ingredients")
public class IngredientRestClient {
    private final RestTemplate restTemplate;

    public IngredientRestClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Ingredient getIngredientById(String ingredientId) {
        return restTemplate.getForObject("http://localhost:8080/ingredients/{id}",
                Ingredient.class, ingredientId);
    }

    public Ingredient getIngredientByIdWithContainer(String ingredientId){
        Map<String, String> urlVariables = new HashMap<>();
        urlVariables.put("id", ingredientId);
        return restTemplate.getForObject("http://localhost:8080/ingredients/{id}",
                Ingredient.class, urlVariables);
    }

    public Ingredient getIngredientByIdWithURI(String ingredientId) {
        Map<String, String> urlVariables = new HashMap<>();
        urlVariables.put("id", ingredientId);
        URI url = UriComponentsBuilder
                .fromHttpUrl("http://localhost:8080/ingredients/{id}")
                .build(urlVariables);
        return restTemplate.getForObject(url, Ingredient.class);
    }

    public Ingredient getIngredientByIdWithResponseEntity(String ingredientId){
        ResponseEntity<Ingredient> responseEntity = restTemplate.getForEntity(
                "http://localhost:8080/ingredients/{id}",
                Ingredient.class, ingredientId
        );
        log.info("Fetched time: {}", responseEntity.getHeaders().getDate());
        return responseEntity.getBody();
    }


    public void updateIngredient(Ingredient ingredient){
        restTemplate.put("http://localhost:8080/ingredients/{id}",
                ingredient, ingredient.getId());
    }

    public void deleteIngredient(Ingredient ingredient){
        restTemplate.delete("http://localhost:8080/ingredients/{id}",
                ingredient, ingredient.getId());
    }

    public Ingredient createIngredient(Ingredient ingredient){
        return restTemplate.postForObject("http://localhost:8080/ingredients", ingredient,
                Ingredient.class);
    }

    public URI createIngredientAndGetLocation(Ingredient ingredient) {
        return restTemplate.postForLocation("http://localhost:8080/ingredients",
                ingredient);
    }

    public Ingredient createIngredientUsingEntity(Ingredient ingredient) {
        ResponseEntity<Ingredient> responseEntity =
                restTemplate.postForEntity("http://localhost:8080/ingredients",
                        ingredient,
                        Ingredient.class);
        log.info("New resource created at {}",
                responseEntity.getHeaders().getLocation());
        return responseEntity.getBody();
    }

}
