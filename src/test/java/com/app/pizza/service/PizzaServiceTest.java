package com.app.pizza.service;

import com.app.pizza.model.ingredient.Cake;
import com.app.pizza.model.ingredient.Cheese;
import com.app.pizza.model.ingredient.Size;
import com.app.pizza.model.type.BasicPizza;
import com.app.pizza.model.type.CheesePizza;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PizzaServiceTest {

    @Mock
    private IngredientService ingredientService;

    @InjectMocks
    private PizzaService pizzaService;

    @Test
    @DisplayName("it should calculate correct price of pizza")
    void test1() {

        var pizza = CheesePizza
                .builder()
                .pizza(BasicPizza
                        .builder()
                        .cake(Cake.THICK)
                        .size(Size.MEDIUM)
                        .build())
                .cheese(Cheese.KIND_ONE)
                .build();

        when(ingredientService.getIngredientPrice(Cake.THICK))
                .thenReturn(BigDecimal.TEN);

        when(ingredientService.getIngredientPrice(Size.MEDIUM))
                .thenReturn(BigDecimal.TEN);

        when(ingredientService.getIngredientPrice(Cheese.KIND_ONE))
                .thenReturn(BigDecimal.TEN);

        var price = pizzaService.getPizzaPrice(pizza);
        assertThat(price)
                .isEqualTo("30");
    }

}