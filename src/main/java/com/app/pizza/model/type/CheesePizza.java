package com.app.pizza.model.type;

import com.app.pizza.model.ingredient.Cheese;
import com.app.pizza.model.ingredient.Ingredient;
import lombok.Builder;

import java.util.List;

@Builder
public class CheesePizza implements Pizza {

    private final Pizza pizza;
    private final Cheese cheese;

    @Override
    public List<Ingredient> getIngredients() {
        var ingredients = pizza.getIngredients();
        ingredients.add(cheese);
        return ingredients;
    }

    @Override
    public String getInfo() {
        return pizza.getInfo() + " Cheese: " + cheese;
    }

}
