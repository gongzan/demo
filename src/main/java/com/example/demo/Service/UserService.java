package com.example.demo.Service;

import com.example.demo.Dao.UserRepository;
import com.example.demo.Dto.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

   @Autowired
   UserRepository userRepository;

   private Logger logger = LoggerFactory.getLogger(UserService.class);

   /**
    * 根据id查询用户
    * @return
    */
   public User getUserById(int id){
      User user = userRepository.getOne(id);
      logger.info("UserService-getUserById,根据Id查询用户，用户json:{}",user);
      return user;
   }

   /**
    * 添加用户
    */
   public void addUser(User user){
      userRepository.save(user);
      logger.info("UserService-addUser,添加用户，用户json:{}",user);
   }

   /**
    * 删除用户
    */
   public void deleteUser(int id){
      userRepository.deleteById(id);
      logger.info("UserService-deleteUser,删除用户，用户id:{}",id);
   }

   /**
    * 查询全部用户
    */
   public void getAllUsers(){
      List<User> users = userRepository.findAll();
      logger.info("UserService-getAllUsers,获取全部用户，用户json:{}",users);
   }

   /**
    * 修改用户
    */
   public void updateUser(User user){
      userRepository.save(user);
      logger.info("UserService-updateUser,修改用户，用户json:{}",user);
   }

}

