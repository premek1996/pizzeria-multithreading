package com.app.pizza.model.type;

import com.app.pizza.model.ingredient.Ingredient;

import java.util.List;

public interface Pizza {

    List<Ingredient> getIngredients();

    String getInfo();

}
