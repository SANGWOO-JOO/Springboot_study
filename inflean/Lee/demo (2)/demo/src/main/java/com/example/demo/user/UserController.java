package com.example.demo.user;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    private UserDaoService service;


    public UserController(UserDaoService service){
        this.service =service;
    }

    //전체 검색
    @GetMapping("/users")
    public List<User> retrieveAllUsers(){
        return  service.findAll();
    }

    // 사용자 검색
    @GetMapping("/user/{id}")
    public User retrieveUser(@PathVariable int id){
        return service.findOne(id);
    }
}