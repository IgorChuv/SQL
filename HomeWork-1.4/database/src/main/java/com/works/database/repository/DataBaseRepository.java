package com.works.database.repository;

import com.works.database.Entity.Persons;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;


@Repository
public class DataBaseRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<?> getPersonsByCity(String cityName) {
        Query query = entityManager.createQuery("select p from Persons p where p.city_of_living like :city_of_living", Persons.class);
        query.setParameter("city_of_living", cityName);
        return query.getResultList();
    }
}

