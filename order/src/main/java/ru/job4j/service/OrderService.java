package ru.job4j.service;

import lombok.AllArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import ru.job4j.dto.OrderDTORequest;
import ru.job4j.model.dish.Dish;
import ru.job4j.model.order.Order;
import ru.job4j.model.order.Status;
import ru.job4j.repository.CustomerRepository;
import ru.job4j.repository.DishRepository;
import ru.job4j.repository.OrderRepository;

import java.util.List;

/**
 * @author: Egor Bekhterev
 * @date: 08.04.2023
 * @project: job4j_fast_food
 */
@Service
@AllArgsConstructor
public class OrderService {

    private KafkaTemplate<String, Object> kafkaTemplate;
    private OrderRepository orderRepository;
    private CustomerRepository customerRepository;
    private DishRepository dishRepository;

    public Order save(OrderDTORequest orderDTORequest) {
        return customerRepository.findById(orderDTORequest.getCustomerId())
                .map(customer -> {
                    var order = new Order();
                    order.setName(orderDTORequest.getName());
                    order.setStatus(orderDTORequest.getStatus());
                    order.setCustomer(customer);
                    List<Dish> dishes = dishRepository.findAllByIdIn(orderDTORequest.getDishIds());
                    order.setDishes(dishes);

                    var savedOrder = orderRepository.save(order);
                    kafkaTemplate.send("job4j_orders", savedOrder);
                    kafkaTemplate.send("messengers", savedOrder);
                    return orderRepository.save(savedOrder);
                }).orElse(null);
    }

    public Status checkStatus(int orderId) {
        return orderRepository.findById(orderId).map(Order::getStatus).orElse(null);
    }

    public Order findById(int id) {
        return orderRepository.findById(id).orElse(null);
    }
}
