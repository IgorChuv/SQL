package com.works.database.repository;

import com.works.database.Entity.Contact;
import com.works.database.Entity.Persons;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Persons, Contact> {

    List<Persons> findByCityOfLiving(String cityName);

    List<Persons> findByContactAgeLessThanOrderByContactAgeAsc(int age);

    Optional<Persons> findByContactNameAndContactSurname(String name, String surname);

}
