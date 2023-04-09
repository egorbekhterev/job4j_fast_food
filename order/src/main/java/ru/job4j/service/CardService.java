package ru.job4j.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.job4j.model.Card;
import ru.job4j.repository.CardRepository;

/**
 * @author: Egor Bekhterev
 * @date: 09.04.2023
 * @project: job4j_fast_food
 */
@Service
@AllArgsConstructor
public class CardService {

    private CardRepository cardRepository;

    public Card save(Card card) {
        return cardRepository.save(card);
    }
}
