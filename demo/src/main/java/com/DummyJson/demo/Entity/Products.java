package com.DummyJson.demo.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;
import org.json.JSONPropertyIgnore;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Data
@JsonIgnoreProperties
@Table(name= "product_table")
public class Products {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long product_id;
    @Column
    private long id;
    @Column
    private String title;
    @Column
    private String description;
    @Column
    private BigDecimal price;
    @Column
    private BigDecimal rating;
    @Column
    private int stock;
    @Column
    private String brand;
    @Column
    private String category;
    @Column

    private List<String> thumbnail;
    @Column
    private List<String> images;

}
