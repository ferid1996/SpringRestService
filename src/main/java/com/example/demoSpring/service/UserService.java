package com.example.demoSpring.service;


import com.example.demoSpring.entity.User;

import java.util.List;

public interface UserService {
    User createUser(User user);
    List<User>getUser();
    User getOneUser(Long id);
    User updateUser(Long id,User body);
    User deleteByUser(Long id);
    Boolean delete(Long id);



}
