package com.DummyJson.demo.Model;

import com.DummyJson.demo.Entity.Product;
import jakarta.persistence.Column;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@Data
@NoArgsConstructor
public class ProductModel {
    private long id;
    private String title;
    private String discription;
    private double price;
    private float rating;
    private int stock;
    private String brand;
    private String category;
    private List<String> thumbNails;
    private List<String> images;
public ProductModel (Product product){
    this.setId(product.getId());
    this.setTitle(product.getTitle());
    this.setDiscription(product.getDiscription());
    this.setPrice(product.getPrice());
    this.setRating(product.getRating());
    this.setStock(product.getStock());
    this.setBrand(product.getBrand());
    this.setCategory(product.getCategory());
    this.setThumbNails(product.getThumbNails());
    this.setImages(product.getImages());
}

public Product dissamble (){
    Product product=new Product();
    product.setId(id);
    product.setTitle(title);
    product.setDiscription(discription);
    product.setPrice(price);
    product.setRating(rating);
    product.setStock(stock);
    product.setBrand(brand);
    product.setCategory(category);
    product.setThumbNails(thumbNails);
    product.setImages(images);
    return product;

}

}
