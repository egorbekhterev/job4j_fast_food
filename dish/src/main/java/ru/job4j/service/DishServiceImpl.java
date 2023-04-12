package ru.job4j.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.job4j.model.dish.Category;
import ru.job4j.model.dish.Ingredient;
import ru.job4j.repository.DishRepository;
import ru.job4j.model.dish.Dish;

import java.util.List;
import java.util.Optional;

/**
 * @author: Egor Bekhterev
 * @date: 11.04.2023
 * @project: job4j_fast_food
 */
@Service
@AllArgsConstructor
public class DishServiceImpl implements DishService {

    private DishRepository dishRepository;

    @Override
    public Dish addDish(Dish dish) {
        return dishRepository.save(dish);
    }

    @Override
    public List<Dish> findByName(String name) {
        return dishRepository.findByName(name);
    }

    @Override
    public List<Dish> findAll() {
        return dishRepository.findAll();
    }

    @Override
    public List<Dish> findByCategory(Category category) {
        return dishRepository.findByCategory(category);
    }

    @Override
    public List<Dish> findByIngredients(List<String> ingredients) {
        return dishRepository.findByIngredients(ingredients);
    }

    @Override
    public boolean deleteById(int id) {
        var rsl = false;
        if (dishRepository.existsById(id)) {
            dishRepository.deleteById(id);
            rsl = true;
        }
        return rsl;
    }

    @Override
    public boolean update(Dish dish, int id) {
        var rsl = false;
        if (dishRepository.existsById(id)) {
            dishRepository.save(dish);
            rsl = true;
        }
        return rsl;
    }

    @Override
    public Optional<Dish> findById(int id) {
        return dishRepository.findById(id);
    }
}
