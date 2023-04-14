package ru.job4j.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import ru.job4j.mapper.OrderMapper;
import ru.job4j.model.order.Order;
import ru.job4j.repository.NotificationRepository;

/**
 * @author: Egor Bekhterev
 * @date: 14.04.2023
 * @project: job4j_fast_food
 */
@Service
@Slf4j
@AllArgsConstructor
public class NotificationService {

    private NotificationRepository notificationRepository;

    @KafkaListener(topics = "messengers")
    public void receiveOrder(Order order) {
        log.debug(order.toString());
        notificationRepository.save(OrderMapper.toDTO(order));
    }
}
