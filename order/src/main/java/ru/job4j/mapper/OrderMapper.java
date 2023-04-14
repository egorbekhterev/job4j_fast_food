package ru.job4j.mapper;

import ru.job4j.dto.OrderDTOResponse;
import ru.job4j.model.order.Order;

/**
 * @author: Egor Bekhterev
 * @date: 09.04.2023
 * @project: job4j_fast_food
 */
public class OrderMapper {

    public static OrderDTOResponse toDTO(Order order) {
        var orderDTO = new OrderDTOResponse();
        orderDTO.setName(order.getName());
        orderDTO.setStatus(order.getStatus().toString());
        orderDTO.setDishes(order.getDishes());
        return orderDTO;
    }
}
