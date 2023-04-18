package ru.job4j.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import ru.job4j.dto.OrderDTORequest;
import ru.job4j.dto.OrderTransfer;
import ru.job4j.mapper.OrderMapper;
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
@Slf4j
@AllArgsConstructor
public class OrderService {

    private OrderRepository orderRepository;
    private CustomerRepository customerRepository;
    private DishRepository dishRepository;
    private KafkaTemplate<String, Object> kafkaTemplate;

    @KafkaListener(topics = "cooked_order")
    public void receiveStatus(OrderTransfer order) {
        StringBuffer stringBuffer = new StringBuffer();
        log.debug(stringBuffer.append(order.getName()).append(" ").append(order.getStatus()).toString());
        kafkaTemplate.send("messengers", OrderMapper.fromDTO(order));
    }

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
                    kafkaTemplate.send("preorder", savedOrder);
                    kafkaTemplate.send("messengers", savedOrder);
                    return savedOrder;
                }).orElse(null);
    }

    public Status checkStatus(int orderId) {
        return orderRepository.findById(orderId).map(Order::getStatus).orElse(null);
    }

    public Order findById(int id) {
        return orderRepository.findById(id).orElse(null);
    }
}
