package ru.job4j.dto;

import lombok.Data;
import ru.job4j.model.dish.Dish;

import java.util.List;

/**
 * @author: Egor Bekhterev
 * @date: 09.04.2023
 * @project: job4j_fast_food
 */
@Data
public class OrderDTOResponse {

    private String name;

    private String status;

    private List<Dish> dishes;
}
