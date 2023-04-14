package ru.job4j.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import ru.job4j.model.dish.Dish;
import ru.job4j.model.order.Customer;
import ru.job4j.model.order.Status;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: Egor Bekhterev
 * @date: 08.04.2023
 * @project: job4j_fast_food
 */
@Data
@Entity(name = "messengers")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private int id;

    private String name;

    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToMany
    @JoinTable(
            name = "orders_dishes",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "dish_id")
    )
    private List<Dish> dishes = new ArrayList<>();
}

