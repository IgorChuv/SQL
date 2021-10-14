package com.works.database.controller;

import com.works.database.Entity.Persons;
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
    public List<?> getPersonsByCity(@RequestParam("city") String cityName) {
        return repository.getPersonsByCity(cityName);
    }

    @GetMapping("/persons/by-age")
    public List<?> getPersonsByAge(@RequestParam("age") int age) {
        return repository.getPersonsByAge(age);
    }

    @GetMapping("/persons/by-name-and-surname")
    public Persons getPersonsByNameAndSurname(@RequestParam("name") String name, @RequestParam("surname") String surname) {
        return repository.getPersonsByNameAndSurname(name, surname);
    }
}
