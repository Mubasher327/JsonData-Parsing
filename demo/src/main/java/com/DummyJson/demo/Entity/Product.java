package com.DummyJson.demo.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name= "product_table")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long id;
    @Column
    private String title;
    @Column
    private String description;
    @Column
    private double price;
    @Column
    private float rating;
    @Column
    private int stock;
    @Column
    private String brand;
    @Column
    private String category;
    @Column

    private String thumbnail;
    @Column
    private List<String> images;

}
