package com.example.demoSpring.controller;

import com.example.demoSpring.entity.User;
import com.example.demoSpring.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

   
    @PostMapping("/create")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User result = userService.createUser(user);
        return ResponseEntity.ok(result);
    }



    @GetMapping("/get")
    public  ResponseEntity <List<User>> getUser(){
        List<User> userList =userService.getUser();
        return  ResponseEntity.ok(userList);
    }


    @GetMapping("/get/{id}")
    public  ResponseEntity<User> getOneuser(@PathVariable Long id ){
        User user =userService.getOneUser(id);
        return  ResponseEntity.ok(user);
    }



    @PutMapping("/update/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id,@RequestBody User body){
        User user = userService.updateUser(id,body);
        return ResponseEntity.ok(user);

    }


    @DeleteMapping("/delete/{id}")
    public  void deleteByUser(@PathVariable Long id){
        User user = userService.deleteByUser(id);
         ResponseEntity.ok(user);
    }


    @DeleteMapping("/delete1/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Long id){
        Boolean user = userService.delete(id);
        return ResponseEntity.ok(user);

    }





}
