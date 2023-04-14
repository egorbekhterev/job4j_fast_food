package ru.job4j.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.job4j.serivce.DishRestTemplateService;

/**
 * @author: Egor Bekhterev
 * @date: 11.04.2023
 * @project: job4j_fast_food
 */
@Controller
@AllArgsConstructor
public class AdminController {

    private final DishRestTemplateService service;

    @GetMapping
    public String findAll(Model model) {
        var products = service.findAll();
        model.addAttribute("products", products);
        return "index";
    }

    @GetMapping("/{id}")
    public String findById(@PathVariable int id, Model model) {
        var product = service.findById(id);
        if (product.isEmpty()) {
            model.addAttribute("message", "No product with that ID exists.");
        }
        model.addAttribute("product", product.get());
        return "one";
    }
}
