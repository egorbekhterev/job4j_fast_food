package ru.job4j.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import ru.job4j.dto.OrderTransfer;
import ru.job4j.service.KitchenService;

/**
 * @author: Egor Bekhterev
 * @date: 09.04.2023
 * @project: job4j_fast_food
 */
@RestController
@AllArgsConstructor
@RequestMapping("/kitchen")
public class KitchenController {

    private KitchenService kitchenService;

    @GetMapping("/updateReady/{id}")
    public ResponseEntity<OrderTransfer> updateReady(@PathVariable int id) {
        var order = kitchenService.updateReady(id).orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Order is not found. Please, check the identificator."
        ));

        return new ResponseEntity<>(order, HttpStatus.OK);
    }
}
