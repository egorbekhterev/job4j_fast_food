package ru.job4j.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.job4j.model.order.Card;
import ru.job4j.model.order.Customer;
import ru.job4j.repository.CardRepository;
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
    private CardRepository cardRepository;

    public Card buyCard(Card card, int id) {
        return customerRepository.findById(id).map(customer -> {
            /* Сохраняем новую карту в таблицу cards. */
            cardRepository.save(card);
            /* Обновляем объект Customer. */
            customer.setCard(card);
            /* Сохраняем обновленный Customer в таблицу customers. */
            customerRepository.save(customer);
            return customer.getCard();
        }).orElse(null);
    }

    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }
}
