package ru.job4j.repository;

import org.springframework.data.repository.CrudRepository;
import ru.job4j.model.Card;

/**
 * @author: Egor Bekhterev
 * @date: 09.04.2023
 * @project: job4j_fast_food
 */
public interface CardRepository extends CrudRepository<Card, Integer> {
}
