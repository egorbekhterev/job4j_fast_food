package ru.job4j.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import ru.job4j.model.order.Order;

/**
 * @author: Egor Bekhterev
 * @date: 14.04.2023
 * @project: job4j_fast_food
 */
@Service
@Slf4j
public class KitchenService {

    @KafkaListener(topics = "job4j_orders")
    public void receiveOrder(Order order) {
        log.debug(order.toString());
    }
}
