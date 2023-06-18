package com.DummyJson.demo.Controller;

import com.DummyJson.demo.Entity.Product;
import com.DummyJson.demo.Model.ProductModel;
import com.DummyJson.demo.Repository.ProductRepo;
import com.DummyJson.demo.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductService productService;

    @PostMapping("/save")
    public String addDummy(@RequestBody ProductModel productModel){
     productService.addDummy(productModel);
     return "Save SuccessFully";
    }
}
