package ru.job4j.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import ru.job4j.model.dish.Dish;
import ru.job4j.model.order.Status;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: Egor Bekhterev
 * @date: 16.04.2023
 * @project: job4j_fast_food
 */
@Data
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "orders")
public class OrderTransfer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private int id;

    private String name;

    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToMany
    @JoinTable(
            name = "orders_dishes",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "dish_id")
    )
    private List<Dish> dishes = new ArrayList<>();
}
