package com.example.demoSpring.service.impl;

import com.example.demoSpring.entity.User;
import com.example.demoSpring.repository.UserRepository;
import com.example.demoSpring.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceimpl  implements UserService {

        private final UserRepository userRepository;


    public UserServiceimpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public User createUser(User user) {
        user.setCreateDate(new Date());
        user.setCreateBy("");

        return userRepository.save(user);
    }

    @Override
    public List<User> getUser() {

        return userRepository.findAll();
    }

    @Override
    public User getOneUser(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User updateUser(Long id, User body) {
        Optional<User> userlist = userRepository.findById(id);
        if (userlist.isPresent()){
            User user =userlist.get();
            user.setFistname(body.getFistname());
            user.setLastname(body.getLastname());
            user.setUpdateAt(new Date());
            user.setUpdateBy("");
            userRepository.save(user);
        }
        return null;
    }

    @Override
    public User deleteByUser(Long id) {
        userRepository.deleteById(id);

        return null;
    }

    @Override
    public Boolean delete(Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()){
            userRepository.deleteById(id);
            return  true;
        }
        return false;


    }


}
