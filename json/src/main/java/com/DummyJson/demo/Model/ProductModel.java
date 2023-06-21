package com.DummyJson.demo.Model;

import com.DummyJson.demo.Entity.Products;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
@Component
@Data
@NoArgsConstructor
public class ProductModel {
    private String id;
    private String title;
    private String description;
    private String price;
    private String discountPercentage;
    private String rating;
    private String stock;
    private String brand;
    private String category;
    private List<String> thumbnail;
    private List<String> images;
public ProductModel (Products product){
    this.setId(product.getId());
    this.setTitle(product.getTitle());
    this.setDescription(product.getDescription());
    this.setPrice(product.getPrice());
    this.setDiscountPercentage(product.getDiscountPercentage());
    this.setRating(product.getRating());
    this.setStock(product.getStock());
    this.setBrand(product.getBrand());
    this.setCategory(product.getCategory());
    this.setThumbnail(product.getThumbnail());
    this.setImages(product.getImages());
}

public Products dissamble (){
    Products product=new Products();
    product.setId(id);
    product.setTitle(title);
    product.setDescription(description);
    product.setPrice(price);
    product.setDiscountPercentage(discountPercentage);
    product.setRating(rating);
    product.setStock(stock);
    product.setBrand(brand);
    product.setCategory(category);
    product.setThumbnail(thumbnail);
    product.setImages(images);
    return product;

}

}
