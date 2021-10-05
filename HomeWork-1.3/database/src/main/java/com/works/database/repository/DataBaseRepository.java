package com.works.database.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class DataBaseRepository {
    String script = "";

    @Autowired
    private JdbcTemplate jdbcTemplate;
@Autowired
private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private static String read(String scriptFileName) {
        try (InputStream is = new ClassPathResource(scriptFileName).getInputStream();
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is))) {
            return bufferedReader.lines().collect(Collectors.joining("\n"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<String> getProductName(String name) {
        List<String> listOfProducts = new ArrayList<>();

        List<?> productList = jdbcTemplate.queryForList("select * from *");
        System.out.println(productList.toString());
        //while(productList.next()){
//
//    String product = sqlRowSet.getString("product_name");
//    System.out.println(product);
//    System.out.println(read(sqlRowSet.toString()));
//    listOfProducts.add(product);
//
//}


        return listOfProducts;
    }

}
