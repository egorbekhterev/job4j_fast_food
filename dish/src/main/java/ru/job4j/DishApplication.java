package ru.job4j;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * @author: Egor Bekhterev
 * @date: 11.04.2023
 * @project: job4j_fast_food
 */
@SpringBootApplication
public class DishApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(DishApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(DishApplication.class, args);
    }
}
