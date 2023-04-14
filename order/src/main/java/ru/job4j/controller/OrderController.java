package ru.job4j.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.job4j.dto.OrderDTORequest;
import ru.job4j.dto.OrderDTOResponse;
import ru.job4j.mapper.OrderMapper;
import ru.job4j.service.OrderService;

/**
 * @author: Egor Bekhterev
 * @date: 09.04.2023
 * @project: job4j_fast_food
 */
@RestController
@AllArgsConstructor
@RequestMapping("/order")
public class OrderController {

    private OrderService orderService;

    @GetMapping("/{id}")
    public ResponseEntity<OrderDTOResponse> findById(@PathVariable int id) {
        var order = orderService.findById(id);
        return new ResponseEntity<>(OrderMapper.toDTO(order), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<OrderDTOResponse> createOrder(@RequestBody OrderDTORequest orderDTORequest) {
        return new ResponseEntity<>(OrderMapper.toDTO(orderService.save(orderDTORequest)), HttpStatus.CREATED);
    }

    @GetMapping("/checkStatus/{orderId}")
    public ResponseEntity<String> checkStatus(@PathVariable int orderId) {
        return new ResponseEntity<>(orderService.checkStatus(orderId).toString(), HttpStatus.OK);
    }
}
