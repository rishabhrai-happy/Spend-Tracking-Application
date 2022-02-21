package com.spendtrackingapplication.Spend.Tracking.Application.controller;

import com.spendtrackingapplication.Spend.Tracking.Application.bussiness.RegistraionService;
import com.spendtrackingapplication.Spend.Tracking.Application.entity.User;
import com.spendtrackingapplication.Spend.Tracking.Application.enums.RoleType;
import com.spendtrackingapplication.Spend.Tracking.Application.enums.WalletType;
import com.spendtrackingapplication.Spend.Tracking.Application.repository.UserRepository;
import com.spendtrackingapplication.Spend.Tracking.Application.request.RegistrationRequest;
import com.spendtrackingapplication.Spend.Tracking.Application.response.UserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RequestController {

    @Autowired
    RegistraionService registraionService;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/user/registration")
    public void  rgister(@RequestBody RegistrationRequest registrationRequest){
        registraionService.register(registrationRequest);
    }

    @GetMapping("/user/registration")
    public List<User> registrationRequest(){
        List<User> list=(List<User>) userRepository.findAll();
        return list;
    }

}
