package ru.job4j.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import ru.job4j.model.order.Status;

import javax.persistence.*;

/**
 * @author: Egor Bekhterev
 * @date: 14.04.2023
 * @project: job4j_fast_food
 */
@Data
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "orders")
public class OrderDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private int id;

    private String name;

    @Enumerated(EnumType.STRING)
    private Status status;
}
