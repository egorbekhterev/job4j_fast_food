package ru.job4j.dto;

import lombok.Data;
import ru.job4j.model.Status;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

/**
 * @author: Egor Bekhterev
 * @date: 10.04.2023
 * @project: job4j_fast_food
 */
@Data
public class OrderDTORequest {

    private String name;

    @Enumerated(EnumType.STRING)
    private Status status;

    private int customerId;
}
