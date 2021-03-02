package com.example.demo.controller;

import com.example.demo.Dto.User;
import com.example.demo.Service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    private Logger logger = LoggerFactory.getLogger(UserController.class);

    @RequestMapping("addUser")
    @ResponseBody
    public String addUser(){
        User user = new User();
        user.setId(1);
        user.setUserName("我爱刘亦菲");
        userService.addUser(user);
        logger.info("UserController-addUser,添加用户,用户json：{}", user);
        return "添加成功";
    }

    @GetMapping("deleteUser")
    @ResponseBody
    public String deleteUser(){
        userService.deleteUser(1);
        logger.info("UserController-deleteUser,删除用户,用户id:", 1);
        return "删除成功";
    }

    @GetMapping("updateUser")
    @ResponseBody
    public String updateUser(){
        User user = new User();
        user.setId(1);
        user.setUserName("我爱刘亦菲");
        userService.updateUser(user);
        logger.info("UserController-updateUser,更新用户,用户json:{}",user);
        return "更新成功";
    }

    @GetMapping("gerAllUsers")
    @ResponseBody
    public String getAllUsers(){
        userService.getAllUsers();
        logger.info("UserController-getAllUsers,获取全部用户");
        return "获取全部用户";
    }

    @GetMapping("getUserById")
    @ResponseBody
    public String getUserById(){
        User user = userService.getUserById(1);
        logger.info("UserController-getById,根据id获取用户,用户id:{}",user.getId());
        return user.toString();
    }
}
