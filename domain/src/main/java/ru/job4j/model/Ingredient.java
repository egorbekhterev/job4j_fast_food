package ru.job4j.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author: Egor Bekhterev
 * @date: 08.04.2023
 * @project: job4j_fast_food
 */
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Ingredient {

    @EqualsAndHashCode.Include
    private int id;

    private String name;
}
