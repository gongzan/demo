package com.example.demo.Service;

import com.example.demo.Dao.UserRepository;
import com.example.demo.Dto.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceTest {

    @Autowired
    UserRepository userRepository;

    @Test
    void getUserById() {
        User user = userRepository.getOne(1);
        System.out.println(user);
    }

    @Test
    void addUser() {
        User user = new User();
        user.setId(10);
        user.setUserName("gz");
        userRepository.save(user);
    }

    @Test
    void deleteUser() {
        userRepository.deleteById(10);
    }

    @Test
    void getAllUsers() {
        userRepository.findAll();
    }

    @Test
    void updateUser() {
        User user = new User();
        user.setId(10);
        user.setUserName("zg");
        userRepository.save(user);
    }
}