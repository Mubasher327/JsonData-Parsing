package com.DummyJson.demo.Repository;


import com.DummyJson.demo.Entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Products, Long> {

}
