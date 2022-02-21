package com.spendtrackingapplication.Spend.Tracking.Application.controller;

import com.spendtrackingapplication.Spend.Tracking.Application.bussiness.ProductService;
import com.spendtrackingapplication.Spend.Tracking.Application.entity.Product;
import com.spendtrackingapplication.Spend.Tracking.Application.repository.ProductRepo;
import com.spendtrackingapplication.Spend.Tracking.Application.request.ProductRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductControllr {


    @Autowired
    private ProductService productService;

    @Autowired
    private ProductRepo productRepo;

    @PostMapping("/product")
    public void add(@RequestBody ProductRequest productRequest){
        productService.product(productRequest);
    }

    @GetMapping("/product")
    public List<Product>  getAll(){
        List<Product> list=(List<Product>) productRepo.findAll();
        return  list;
    }
}
