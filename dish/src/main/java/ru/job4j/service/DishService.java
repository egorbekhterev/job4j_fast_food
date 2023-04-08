package ru.job4j.service;

import ru.job4j.model.Dish;

import java.util.List;
import java.util.Optional;

/**
 * @author: Egor Bekhterev
 * @date: 08.04.2023
 * @project: job4j_fast_food
 */
public interface DishService {

    Dish addDish(Dish dish);

    Optional<Dish> findByName(String name);

    List<Dish> findAll();

    List<Dish> findByIngredients(List<String> ingredients);

    void deleteById(int id);

    void update(Dish dish);
}
