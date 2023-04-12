package ru.job4j.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.job4j.model.dish.Category;
import ru.job4j.model.dish.Dish;
import ru.job4j.service.DishServiceImpl;

import java.util.List;

/**
 * @author: Egor Bekhterev
 * @date: 11.04.2023
 * @project: job4j_fast_food
 */
@RestController
@AllArgsConstructor
@RequestMapping("/dish")
public class DishController {

    private DishServiceImpl dishService;

    @GetMapping
    public List<Dish> findAll() {
        return dishService.findAll();
    }

    @PostMapping
    public Dish save(@RequestBody Dish dish) {
        return dishService.addDish(dish);
    }

    @GetMapping("/{id}")
    public Dish findById(@PathVariable int id) {
        return dishService.findById(id).orElse(null);
    }

    @GetMapping("/category/{category}")
    public List<Dish> findByCategory(@PathVariable Category category) {
        return dishService.findByCategory(category);
    }

    @PutMapping
    public ResponseEntity<Void> update(@PathVariable int id, @RequestBody Dish dish) {
        boolean status = dishService.update(dish, id);
        return ResponseEntity
                .status(status ? HttpStatus.OK : HttpStatus.NOT_FOUND)
                .build();
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(@PathVariable int id) {
        boolean status = dishService.deleteById(id);
        return ResponseEntity
                .status(status ? HttpStatus.OK : HttpStatus.NOT_FOUND)
                .build();
    }

    @GetMapping("/name/{name}")
    public List<Dish> findByName(@PathVariable String name) {
        return dishService.findByName(name);
    }

    @GetMapping("/ingredients/{ingredients}")
    public List<Dish> findByIngredients(@RequestParam List<String> ingredients) {
        return dishService.findByIngredients(ingredients);
    }
}
