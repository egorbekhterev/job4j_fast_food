package ru.job4j.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.job4j.dto.OrderDTORequest;
import ru.job4j.model.order.Order;
import ru.job4j.model.order.Status;
import ru.job4j.repository.CustomerRepository;
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
    private CustomerRepository customerRepository;

    public Order save(OrderDTORequest orderDTORequest) {
        return customerRepository.findById(orderDTORequest.getCustomerId())
                .map(customer -> {
                    var order = new Order();
                    order.setName(orderDTORequest.getName());
                    order.setStatus(orderDTORequest.getStatus());
                    order.setCustomer(customer);
                    return orderRepository.save(order);
                }).orElse(null);
    }

    public Status checkStatus(int orderId) {
        return orderRepository.findById(orderId).map(Order::getStatus).orElse(null);
    }
}
