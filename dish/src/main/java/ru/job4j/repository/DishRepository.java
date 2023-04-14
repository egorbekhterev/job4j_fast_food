package ru.job4j.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import ru.job4j.model.dish.Category;
import ru.job4j.model.dish.Dish;

import java.util.List;

/**
 * @author: Egor Bekhterev
 * @date: 11.04.2023
 * @project: job4j_fast_food
 */
public interface DishRepository extends CrudRepository<Dish, Integer> {

    List<Dish> findByName(String name);

    List<Dish> findAll();

    @Query("SELECT d FROM Dish d JOIN FETCH d.ingredients i WHERE i.name IN :ingredients")
    List<Dish> findByIngredients(List<String> ingredients);

    @Query("SELECT d FROM Dish d WHERE d.category = :category")
    List<Dish> findByCategory(Category category);

    List<Dish> findAllByIdIn(List<Integer> dishIds);
}
