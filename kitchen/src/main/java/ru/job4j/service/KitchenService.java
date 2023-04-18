package ru.job4j.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import ru.job4j.dto.OrderTransfer;
import ru.job4j.mapper.OrderMapper;
import ru.job4j.model.dish.Dish;
import ru.job4j.model.order.Order;
import ru.job4j.model.order.Status;
import ru.job4j.repository.KitchenRepository;

import java.util.Optional;


/**
 * @author: Egor Bekhterev
 * @date: 14.04.2023
 * @project: job4j_fast_food
 */
@Service
@Slf4j
@AllArgsConstructor
public class KitchenService {

    private KitchenRepository kitchenRepository;
    private KafkaTemplate<String, Object> kafkaTemplate;

    public Optional<OrderTransfer> updateReady(int id) {
        var rsl = kitchenRepository.findById(id).map(order -> {
            order.setStatus(Status.READY);
            return kitchenRepository.save(order);
                });

        rsl.ifPresent(orderTransfer -> kafkaTemplate.send("cooked_order", orderTransfer));
        return rsl;
    }

    @KafkaListener(topics = "preorder")
    public void receiveOrder(Order order) {
        if (!order.getDishes().stream().map(Dish::getId).filter(integer -> integer == 3).toList().isEmpty()) {
            log.debug("Impossible to cook this order, no ingredients for one of these products: {}", order.getDishes());
            kafkaTemplate.send("impossible", order);
        } else {
            log.debug(order.toString());
            var dto = OrderMapper.toDTO(order);
            kitchenRepository.save(dto);
        }
    }
}
