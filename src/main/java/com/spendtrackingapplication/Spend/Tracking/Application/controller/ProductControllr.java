package com.spendtrackingapplication.Spend.Tracking.Application.controller;

import com.spendtrackingapplication.Spend.Tracking.Application.bussiness.ProductService;
import com.spendtrackingapplication.Spend.Tracking.Application.bussiness.UserService;
import com.spendtrackingapplication.Spend.Tracking.Application.entity.Product;
import com.spendtrackingapplication.Spend.Tracking.Application.entity.User;
import com.spendtrackingapplication.Spend.Tracking.Application.repository.ProductRepo;
import com.spendtrackingapplication.Spend.Tracking.Application.repository.UserRepository;
import com.spendtrackingapplication.Spend.Tracking.Application.request.ProductRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.method.P;
import org.springframework.web.bind.annotation.*;

import javax.xml.bind.ValidationException;
import java.util.List;

@RestController
public class ProductControllr {

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductRepo productRepo;

    @Autowired
    UserService userService;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/admin/product")
    public void add(@RequestBody ProductRequest productRequest){
        productService.product(productRequest);
    }

    @GetMapping("/admin/product")
    public List<Product>  getAll(){
        List<Product> list=(List<Product>) productRepo.findAll();
        return  list;
    }

    @DeleteMapping("/admin/{id}")
    public void deleteProduct(@PathVariable("id") String id){
        productService.deleteProduct(id);
    }

    @PutMapping("/admin/update/{id}")
    public void updateProduct(@RequestBody ProductRequest productRequest ,@PathVariable("id") String id) throws ValidationException {
        productService.updateProfile(productRequest,id);
    }

    @GetMapping("/admin/registration")
    public List<User> registrationRequest(){
        return userService.registrationRequest();
    }
}
