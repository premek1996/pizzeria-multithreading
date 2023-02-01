package com.app.pizza.model.type;

import com.app.pizza.model.ingredient.Ham;
import com.app.pizza.model.ingredient.Ingredient;
import lombok.Builder;

import java.util.List;

@Builder
public class HamPizza implements Pizza {

    private final Pizza pizza;
    private final Ham ham;

    @Override
    public List<Ingredient> getIngredients() {
        var ingredients = pizza.getIngredients();
        ingredients.add(ham);
        return ingredients;
    }

    @Override
    public String getInfo() {
        return pizza.getInfo() + " Ham: " + ham;
    }

}
