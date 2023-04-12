package ru.job4j.repository;

import org.springframework.data.repository.CrudRepository;
import ru.job4j.model.order.Customer;

/**
 * @author: Egor Bekhterev
 * @date: 08.04.2023
 * @project: job4j_fast_food
 */
public interface CustomerRepository extends CrudRepository<Customer, Integer> {
}
