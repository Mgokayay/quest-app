package com.project.questapp.controller;

import com.project.questapp.entity.User;
import com.project.questapp.repository.UserRepository;
import com.project.questapp.service.UserService;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/")
   public User save(@RequestBody User user) {
        return userService.save(user);
   }
   @GetMapping("/")
   public List<User> findAllUser(){
        return userService.findAll();
   }
   @GetMapping("/{userId}")
   public User findById(@PathVariable Long userId){
        return userService.findById(userId);
   }
   @PutMapping("/{userId}")
   public User update(@RequestBody User user,@PathVariable Long userId){
        return userService.update(user,userId);
   }
   @DeleteMapping("/{userId}")
   public User delete(@PathVariable Long userId){
        return userService.delete(userId);
   }


}
