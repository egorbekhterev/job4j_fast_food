package ru.job4j.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.job4j.model.Card;
import ru.job4j.repository.CustomerRepository;

/**
 * @author: Egor Bekhterev
 * @date: 08.04.2023
 * @project: job4j_fast_food
 */
@Service
@AllArgsConstructor
public class CustomerService {

    private CustomerRepository customerRepository;

    public Card buyCard(Card card, int id) {
        return customerRepository.findById(id).map(customer -> {
            customer.setCard(card);
            return customer.getCard();
        }).orElse(null);
    }
}
