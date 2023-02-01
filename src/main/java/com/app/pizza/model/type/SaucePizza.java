package com.app.pizza.model.type;

import com.app.pizza.model.ingredient.Ingredient;
import com.app.pizza.model.ingredient.Sauce;
import lombok.Builder;

import java.util.List;

@Builder
public class SaucePizza implements Pizza {

    private final Pizza pizza;
    private final Sauce sauce;


    @Override
    public List<Ingredient> getIngredients() {
        var ingredients = pizza.getIngredients();
        ingredients.add(sauce);
        return ingredients;
    }

    @Override
    public String getInfo() {
        return pizza.getInfo() + " Sauce: " + sauce;
    }

}
