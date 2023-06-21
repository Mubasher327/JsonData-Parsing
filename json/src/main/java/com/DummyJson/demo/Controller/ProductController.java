package com.DummyJson.demo.Controller;

import com.DummyJson.demo.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping("/save")
    public String addDummy(){
        productService.addDummy();
        return "Save SuccessFully";
    }
}

