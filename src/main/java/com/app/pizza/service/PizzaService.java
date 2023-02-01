package com.app.pizza.service;

import com.app.pizza.model.type.Pizza;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class PizzaService {

    private final IngredientService ingredientService;

    public BigDecimal getPizzaPrice(Pizza pizza) {
        return pizza.getIngredients()
                .stream()
                .map(ingredientService::getIngredientPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

}
