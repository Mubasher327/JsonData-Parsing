package com.DummyJson.demo.Service;

import com.DummyJson.demo.Entity.Product;
import com.DummyJson.demo.Model.ProductModel;
import com.DummyJson.demo.Repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepo productRepo;

        public void addDummy(ProductModel productModel) {
            RestTemplate restTemplate = new RestTemplate();
            String apiUrl = "https://dummyjson.com/products";

            ResponseEntity<Product[]> responseEntity = restTemplate.getForEntity(apiUrl, Product[].class);
            if (responseEntity.getStatusCode().is2xxSuccessful()) {
                Product[] dummyDataArray = responseEntity.getBody();

                if (dummyDataArray != null) {
                    List<Product> dummyDataList = Arrays.asList(dummyDataArray);

                    productRepo.saveAll(dummyDataList);
                }
            }
        }
    }


