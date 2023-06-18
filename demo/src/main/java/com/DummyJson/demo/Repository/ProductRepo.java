package com.DummyJson.demo.Repository;


import com.DummyJson.demo.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository< Product, Long> {

}
