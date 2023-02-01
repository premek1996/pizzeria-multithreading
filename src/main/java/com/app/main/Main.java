package com.app.main;

import com.app.config.AppSpringConfig;
import com.app.pizza.model.ingredient.*;
import com.app.pizza.model.type.*;
import com.app.pizza.service.PizzaService;
import com.app.pizzeria.Pizzeria;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(AppSpringConfig.class);
        var pizzaService = context.getBean(PizzaService.class);

        var pizzas = getPizzasToPrepare();

        var pizzeria = new Pizzeria(pizzaService, pizzas);

        var pizzaOrdersCollector = new Thread(pizzeria::collectPizzaOrders);
        pizzaOrdersCollector.start();

        int preparingPizzaThreadsNumber = 10;
        ExecutorService executorService = Executors.newFixedThreadPool(preparingPizzaThreadsNumber);
        for (int i = 0; i < preparingPizzaThreadsNumber; i++) {
            executorService.submit(pizzeria::preparePizzas);
        }
        executorService.shutdown();
    }

    private static List<Pizza> getPizzasToPrepare() {
        List<Pizza> pizzas = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            var basicPizza = BasicPizza
                    .builder()
                    .cake(Cake.THICK)
                    .size(Size.MEDIUM)
                    .build();

            var cheesePizza = CheesePizza
                    .builder()
                    .pizza(basicPizza)
                    .cheese(Cheese.KIND_ONE)
                    .build();

            var hamPizza = HamPizza.builder()
                    .ham(Ham.KIND_ONE)
                    .pizza(cheesePizza)
                    .build();


            var saucePizza = SaucePizza.builder()
                    .pizza(hamPizza)
                    .sauce(Sauce.GARLIC)
                    .build();


            pizzas.add(basicPizza);
            pizzas.add(cheesePizza);
            pizzas.add(hamPizza);
            pizzas.add(saucePizza);

        }
        return pizzas;
    }

}
