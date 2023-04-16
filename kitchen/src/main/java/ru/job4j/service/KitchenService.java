package ru.job4j.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import ru.job4j.mapper.OrderMapper;
import ru.job4j.model.order.Order;
import ru.job4j.model.order.Status;
import ru.job4j.repository.KitchenRepository;


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

    @Scheduled(fixedDelay = 30000)
    private void sendOrder(Order order) {
        order.setStatus(Status.READY);
        kitchenRepository.findById(order.getId()).map(ord -> kitchenRepository.save(OrderMapper.toDTO(order)))
                .orElse(null);
        kafkaTemplate.send("ready_order", order);
    }

    @KafkaListener(topics = "preorder")
    public void receiveOrder(Order order) {
        log.debug(order.toString());
        var dto = OrderMapper.toDTO(order);
        kitchenRepository.save(dto);

        sendOrder(order);
    }
}
