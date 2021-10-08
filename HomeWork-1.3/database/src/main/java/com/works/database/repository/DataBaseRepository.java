package com.works.database.repository;

import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class DataBaseRepository {

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public String script = "MyScript.sql";
    public String searchColumn = "product_name";

    public DataBaseRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    private static String read(String scriptFileName) {
        try (InputStream is = new ClassPathResource(scriptFileName).getInputStream();
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is))) {
            return bufferedReader.lines().collect(Collectors.joining("\n"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<String> getProductName(String name) {
        List<String> productList = new ArrayList<>();
        SqlRowSet sqlRowSet = namedParameterJdbcTemplate.queryForRowSet(read(script), Map.of("name", name));
        while (sqlRowSet.next()) {
            productList.add(sqlRowSet.getString(searchColumn));
        }
        return productList;
    }
}

