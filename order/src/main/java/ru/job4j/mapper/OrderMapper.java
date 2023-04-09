package ru.job4j.mapper;

import ru.job4j.dto.OrderDTO;
import ru.job4j.model.Order;

/**
 * @author: Egor Bekhterev
 * @date: 09.04.2023
 * @project: job4j_fast_food
 */
public class OrderMapper {

    public static OrderDTO toDTO(Order order) {
        var orderDTO = new OrderDTO();
        orderDTO.setName(order.getName());
        orderDTO.setStatus(order.getStatus().toString());
        return orderDTO;
    }
}
