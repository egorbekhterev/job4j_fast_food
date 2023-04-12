package ru.job4j.service;

import ru.job4j.model.dish.Category;
import ru.job4j.model.dish.Dish;

import java.util.List;
import java.util.Optional;

/**
 * @author: Egor Bekhterev
 * @date: 08.04.2023
 * @project: job4j_fast_food
 */
public interface DishService {

    Dish addDish(Dish dish);

    List<Dish> findByName(String name);

    List<Dish> findAll();

    Optional<Dish> findById(int id);

    List<Dish> findByCategory(Category category);

    List<Dish> findByIngredients(List<String> ingredients);

    boolean deleteById(int id);

    boolean update(Dish dish, int id);
}
