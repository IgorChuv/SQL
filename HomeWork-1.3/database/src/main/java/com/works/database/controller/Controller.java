package com.works.database.controller;

import com.works.database.repository.DataBaseRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class Controller {
    DataBaseRepository repo = new DataBaseRepository();

    @GetMapping("/products/fetch-product")
    public List<?> getProductName(@RequestParam ("name") String name){
        return repo.getProductName(name);
    }



}
