package com.works.database.controller;

import com.works.database.repository.DataBaseRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {
    private final DataBaseRepository repository;

    public Controller(DataBaseRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/persons/by-city")
    public List<?> getProductName(@RequestParam("city") String cityName) {
        return repository.getPersonsByCity(cityName);
    }

}
