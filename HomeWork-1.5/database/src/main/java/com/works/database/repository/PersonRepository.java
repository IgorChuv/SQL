package com.works.database.repository;

import com.works.database.Entity.Contact;
import com.works.database.Entity.Persons;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Persons, Contact> {

    @Query("select p from Persons p where p.cityOfLiving like :cityName")
    List<Persons> findByCityOfLiving(@Param("cityName") String cityName);

    @Query("select p from Persons p where p.contact.age < :age order by p.contact.age")
    List<Persons> findByContactAgeLessThanOrderByContactAgeAsc(@Param("age") int age);

    @Query("select p from Persons p where p.contact.name like :name and p.contact.surname like :surname")
    Optional<Persons> findByContactNameAndContactSurname(@Param("name") String name, @Param("surname") String surname);

}