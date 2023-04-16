package ru.job4j.mapper;

import ru.job4j.dto.OrderTransfer;
import ru.job4j.model.order.Order;

/**
 * @author: Egor Bekhterev
 * @date: 16.04.2023
 * @project: job4j_fast_food
 */
public class OrderMapper {

    public static OrderTransfer toDTO(Order order) {
        var orderDTO = new OrderTransfer();
        orderDTO.setName(order.getName());
        orderDTO.setStatus(order.getStatus());
        orderDTO.setDishes(order.getDishes());
        return orderDTO;
    }
}
