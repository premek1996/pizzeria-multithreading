package com.app.pizza.model.type;

import com.app.pizza.model.ingredient.Cake;
import com.app.pizza.model.ingredient.Ingredient;
import com.app.pizza.model.ingredient.Size;
import lombok.Builder;

import java.util.ArrayList;
import java.util.List;

@Builder
public class BasicPizza implements Pizza {

    private final Cake cake;
    private final Size size;

    @Override
    public List<Ingredient> getIngredients() {
        var ingredients = new ArrayList<Ingredient>();
        ingredients.add(cake);
        ingredients.add(size);
        return ingredients;
    }

    @Override
    public String getInfo() {
        return "Cake: " + cake + " Size: " + size;
    }

}
