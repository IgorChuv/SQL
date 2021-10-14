package com.works.database.repository;

import com.works.database.Entity.Persons;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import java.util.List;


@Repository
public class DataBaseRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    PersonRepository personRepository;

    public List<?> getPersonsByCity(String cityName) {
        return personRepository.findByCityOfLiving(cityName);
    }

    public List<?> getPersonsByAge(int age) {
        return personRepository.findByContactAgeLessThanOrderByContactAgeAsc(age);
    }

    public Persons getPersonsByNameAndSurname(String name, String surname) {
        return personRepository.findByContactNameAndContactSurname(name, surname)
                .orElseThrow(() -> new EntityNotFoundException("Person not found"));
    }
}

