package ru.job4j.repository;

import org.springframework.data.repository.CrudRepository;
import ru.job4j.dto.OrderTransfer;

/**
 * @author: Egor Bekhterev
 * @date: 16.04.2023
 * @project: job4j_fast_food
 */
public interface KitchenRepository extends CrudRepository<OrderTransfer, Integer> {
}
