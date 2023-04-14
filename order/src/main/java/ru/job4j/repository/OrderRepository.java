package ru.job4j.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import ru.job4j.model.order.Order;

import java.util.Optional;

/**
 * @author: Egor Bekhterev
 * @date: 08.04.2023
 * @project: job4j_fast_food
 */
public interface OrderRepository extends CrudRepository<Order, Integer> {

    @Query("SELECT o FROM Order o JOIN FETCH o.dishes d where o.id = :id")
    Optional<Order> findById(int id);
}
