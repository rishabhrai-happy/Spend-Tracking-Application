package com.spendtrackingapplication.Spend.Tracking.Application.controller;

import com.spendtrackingapplication.Spend.Tracking.Application.bussiness.RegistraionService;
import com.spendtrackingapplication.Spend.Tracking.Application.bussiness.UserService;
import com.spendtrackingapplication.Spend.Tracking.Application.entity.Product;
import com.spendtrackingapplication.Spend.Tracking.Application.entity.User;
import com.spendtrackingapplication.Spend.Tracking.Application.entity.UserWallet;
import com.spendtrackingapplication.Spend.Tracking.Application.repository.UserRepository;
import com.spendtrackingapplication.Spend.Tracking.Application.request.RegistrationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.xml.bind.ValidationException;
import java.util.List;

@RestController
public class RequestController {

    @Autowired
    RegistraionService registraionService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userSrvic;

    @PostMapping("/registration")
    public void  rgister(@RequestBody RegistrationRequest registrationRequest){
        registraionService.register(registrationRequest);
    }

    @GetMapping("/user/balance/{id}")
    public UserWallet viewWallet(@PathVariable(name = "id") String id) {
        return userSrvic.viewWallet(id);
    }

    @PutMapping("/user/update/{email}")
    public void updateProfile(@RequestBody RegistrationRequest registrationRequest,@PathVariable("email") String email ) throws ValidationException {
        userSrvic.updateProfile(registrationRequest,email);
    }

    @GetMapping("/product/{categories}")
   public List<Product> getByCategories(@PathVariable("categories") String categories){
        return userSrvic.getByCategories(categories);
    }
}
