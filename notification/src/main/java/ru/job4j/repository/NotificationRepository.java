package ru.job4j.repository;

import org.springframework.data.repository.CrudRepository;
import ru.job4j.dto.OrderDTO;

/**
 * @author: Egor Bekhterev
 * @date: 14.04.2023
 * @project: job4j_fast_food
 */
public interface NotificationRepository extends CrudRepository<OrderDTO, Integer> {
}
