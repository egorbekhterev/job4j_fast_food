package ru.job4j.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.job4j.model.Order;
import ru.job4j.model.Status;
import ru.job4j.repository.OrderRepository;

/**
 * @author: Egor Bekhterev
 * @date: 08.04.2023
 * @project: job4j_fast_food
 */
@Service
@AllArgsConstructor
public class OrderService {

    private OrderRepository orderRepository;

    public Order save(Order order) {
        return orderRepository.save(order);
    }

    public Status checkStatus(int orderId) {
        return orderRepository.findById(orderId).map(Order::getStatus).orElse(null);
    }
}
