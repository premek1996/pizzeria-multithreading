package com.app.pizzeria;

import com.app.pizza.model.type.Pizza;
import com.app.pizza.service.PizzaService;
import lombok.SneakyThrows;

import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class Pizzeria {

    private final PizzaService pizzaService;
    private final List<Pizza> pizzas;
    private final BlockingQueue<Pizza> pizzasOrders;

    public Pizzeria(PizzaService pizzaService, List<Pizza> pizzas) {
        this.pizzaService = pizzaService;
        this.pizzas = pizzas;
        this.pizzasOrders = new LinkedBlockingQueue<>();
    }

    @SneakyThrows
    public void collectPizzaOrders() {
        for (Pizza pizza : pizzas) {
            System.out.println();
            System.out.println(Thread.currentThread().getName() + " Ordered pizza: " + pizza.getInfo());
            System.out.println(Thread.currentThread().getName() + " Price: " + pizzaService.getPizzaPrice(pizza));
            System.out.println(Thread.currentThread().getName() + " Pizza will be prepared...");
            pizzasOrders.put(pizza);
        }
    }

    @SneakyThrows
    public void preparePizzas() {
        Pizza pizza;
        do {
            pizza = pizzasOrders.poll(3, TimeUnit.SECONDS);
            if (pizza != null) {
                System.out.println(Thread.currentThread().getName() + " Preparing pizza...");
                Thread.sleep(1_000);
                System.out.println(Thread.currentThread().getName() + " Pizza is already prepared: " + pizza.getInfo());
                System.out.println();
            }
        } while (pizza != null);
    }

}

