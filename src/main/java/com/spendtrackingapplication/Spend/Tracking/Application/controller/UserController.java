package com.spendtrackingapplication.Spend.Tracking.Application.controller;

import com.spendtrackingapplication.Spend.Tracking.Application.bussiness.UserService;
import com.spendtrackingapplication.Spend.Tracking.Application.entity.User;
import com.spendtrackingapplication.Spend.Tracking.Application.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/admin")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/admin/all")
    public List<User> getAll(){
        return userService.getAll();
    }

    @PostMapping("/admin/all")
    public User add(@RequestBody User user){
        return userService.createUser(user);
    }

    @GetMapping("/user/{id}")
    public Optional<User> getById(@PathVariable(name = "id") String id){
        return userService.getById(id);
    }

}
