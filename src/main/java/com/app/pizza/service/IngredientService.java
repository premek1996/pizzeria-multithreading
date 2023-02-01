package com.app.pizza.service;

import com.app.pizza.model.ingredient.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Service
public class IngredientService {

    //cake
    @Value("${price.cake.thin}")
    private String cakeThinPrice;

    @Value("${price.cake.medium}")
    private String cakeMediumPrice;

    @Value("${price.cake.thick}")
    private String cakeThickPrice;

    //size
    @Value("${price.size.small}")
    private String sizeSmallPrice;

    @Value("${price.size.medium}")
    private String sizeMediumPrice;

    @Value("${price.size.large}")
    private String sizeLargePrice;

    //cheese
    @Value("${price.cheese.kind_one}")
    private String cheeseKindOnePrice;

    @Value("${price.cheese.kind_two}")
    private String cheeseKindTwoPrice;

    @Value("${price.cheese.kind_three}")
    private String cheeseKindThreePrice;

    //ham
    @Value("${price.ham.kind_one}")
    private String hamKindOnePrice;

    @Value("${price.ham.kind_two}")
    private String hamKindTwoPrice;

    @Value("${price.ham.kind_three}")
    private String hamKindThreePrice;

    //sauce
    @Value("${price.sauce.garlic}")
    private String sauceGarlicPrice;

    @Value("${price.sauce.ketchup}")
    private String sauceKetchupPrice;

    @Value("${price.sauce.sweet_and_sour}")
    private String sauceSweetAndSourPrice;

    private Map<Ingredient, BigDecimal> ingredientPrices;

    @PostConstruct
    public void init() {
        ingredientPrices = new HashMap<>();

        //cake
        ingredientPrices.put(Cake.THIN, new BigDecimal(cakeThinPrice));
        ingredientPrices.put(Cake.MEDIUM, new BigDecimal(cakeMediumPrice));
        ingredientPrices.put(Cake.THICK, new BigDecimal(cakeThickPrice));

        //size
        ingredientPrices.put(Size.SMALL, new BigDecimal(sizeSmallPrice));
        ingredientPrices.put(Size.MEDIUM, new BigDecimal(sizeMediumPrice));
        ingredientPrices.put(Size.LARGE, new BigDecimal(sizeLargePrice));

        //cheese
        ingredientPrices.put(Cheese.KIND_ONE, new BigDecimal(cheeseKindOnePrice));
        ingredientPrices.put(Cheese.KIND_TWO, new BigDecimal(cheeseKindTwoPrice));
        ingredientPrices.put(Cheese.KIND_THREE, new BigDecimal(cheeseKindThreePrice));

        //ham
        ingredientPrices.put(Ham.KIND_ONE, new BigDecimal(hamKindOnePrice));
        ingredientPrices.put(Ham.KIND_TWO, new BigDecimal(hamKindTwoPrice));
        ingredientPrices.put(Ham.KIND_THREE, new BigDecimal(hamKindThreePrice));

        //sauce
        ingredientPrices.put(Sauce.GARLIC, new BigDecimal(sauceGarlicPrice));
        ingredientPrices.put(Sauce.KETCHUP, new BigDecimal(sauceKetchupPrice));
        ingredientPrices.put(Sauce.SWEET_AND_SOUR, new BigDecimal(sauceSweetAndSourPrice));
    }

    public BigDecimal getIngredientPrice(Ingredient ingredient) {
        return ingredientPrices.get(ingredient);
    }

}
