package ru.job4j.serivce;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.job4j.model.dish.Category;
import ru.job4j.model.dish.Dish;
import ru.job4j.service.DishService;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * @author: Egor Bekhterev
 * @date: 11.04.2023
 * @project: job4j_fast_food
 */
@Service
public class DishRestTemplateService implements DishService {

    @Value("${api-url}")
    private String url;

    private final RestTemplate client;

    public DishRestTemplateService(RestTemplate client) {
        this.client = client;
    }

    @Override
    public Dish addDish(Dish dish) {
        return client.postForEntity(
                url, dish, Dish.class
        ).getBody();
    }

    private List<Dish> getList(String url) {
        List<Dish> body = client.exchange(
                url, HttpMethod.GET, null,
                new ParameterizedTypeReference<List<Dish>>() {
                }
        ).getBody();
        return body == null ? Collections.emptyList() : body;
    }

    @Override
    public List<Dish> findByName(String name) {
        return getList(String.format(
                "%s/name/%s", url, name
        ));
    }

    @Override
    public List<Dish> findAll() {
        return getList(String.format(
                "%s", url
        ));
    }

    @Override
    public Optional<Dish> findById(int id) {
        return Optional.ofNullable(client.getForEntity(
                String.format("%s/%s", url, id),
                Dish.class
        ).getBody());
    }

    @Override
    public List<Dish> findByCategory(Category category) {
        return getList(String.format(
                "%s/category/%s", url, category
        ));
    }

    @Override
    public List<Dish> findByIngredients(List<String> ingredients) {
        return null;
    }

    @Override
    public boolean deleteById(int id) {
        return client.exchange(
                String.format("%s?id=%s", url, id),
                HttpMethod.DELETE,
                HttpEntity.EMPTY,
                Void.class
        ).getStatusCode() != HttpStatus.NOT_FOUND;
    }

    @Override
    public boolean update(Dish dish, int id) {
        return client.exchange(
                String.format("%s?id=%s", url, id),
                HttpMethod.PUT,
                new HttpEntity<>(dish),
                Void.class
        ).getStatusCode() != HttpStatus.NOT_FOUND;
    }
}
