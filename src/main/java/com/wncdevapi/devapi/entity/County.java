package com.wncdevapi.devapi.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "county")
public class County {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long county_id;

    @NotEmpty
    private String county_name;

    

    public County() {
    }

    public County(String name, int population) {

        this.county_name = name;
    }

    public Long getId() {

        return county_id;
    }

    public void setId(Long id) {

        this.county_id = id;
    }

    public String getName() {
        return county_name;
    }

    public void setName(String name) {

        this.county_name = name;
    }



}
