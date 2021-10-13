package com.works.database.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Persons {

    @EmbeddedId
    private Contact contact;

    private String phone_number;

    private String city_of_living;

}
