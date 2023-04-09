package ru.job4j.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.job4j.dto.OrderDTO;
import ru.job4j.mapper.OrderMapper;
import ru.job4j.model.Order;
import ru.job4j.service.OrderService;

/**
 * @author: Egor Bekhterev
 * @date: 09.04.2023
 * @project: job4j_fast_food
 */
@RestController
@AllArgsConstructor
public class OrderController {

    private OrderService orderService;

    @PostMapping("/createOrder")
    public ResponseEntity<OrderDTO> createOrder(@RequestBody Order order) {
        return new ResponseEntity<>(OrderMapper.toDTO(orderService.save(order)), HttpStatus.CREATED);
    }

    @GetMapping("/checkStatus/{orderId}")
    public ResponseEntity<String> checkStatus(@PathVariable int orderId) {
        return new ResponseEntity<>(orderService.checkStatus(orderId).toString(), HttpStatus.OK);
    }
}
