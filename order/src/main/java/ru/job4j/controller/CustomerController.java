package ru.job4j.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.job4j.model.Card;
import ru.job4j.service.CustomerService;

/**
 * @author: Egor Bekhterev
 * @date: 09.04.2023
 * @project: job4j_fast_food
 */
@RestController
@AllArgsConstructor
public class CustomerController {

    private CustomerService customerService;

    @PostMapping("/buyCard/{id}")
    public ResponseEntity<Integer> buyCard(@RequestBody Card card, @PathVariable int id) {
        return new ResponseEntity<>(customerService.buyCard(card, id).getCardNumber(), HttpStatus.CREATED);
    }
}
