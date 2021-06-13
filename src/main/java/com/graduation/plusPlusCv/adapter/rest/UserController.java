package com.graduation.plusPlusCv.adapter.rest;

import com.graduation.plusPlusCv.models.User;
import com.graduation.plusPlusCv.service.DTOs.UserDTO;
import com.graduation.plusPlusCv.service.DTOs.UserRegistrationDTO;
import com.graduation.plusPlusCv.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/user")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable String id){
        return userService.getUserById(id);
    }

    @PostMapping
    public boolean registration(@RequestBody UserRegistrationDTO userRegistrationDTO){
        return userService.registerNewUser(userRegistrationDTO);
    }

    @PostMapping("/login")
    public UserDTO login(@RequestParam String email,@RequestParam String password){
        return userService.login(email,password);
    }
    @PutMapping("/{id}")
    public User updateUser (@PathVariable String id , @RequestParam String name ) {
     return	userService.updateUser(id , name);
    	
    }
    @PutMapping("password/{id}")
    public User updatePassword (@PathVariable String id , @RequestParam String password  , @RequestParam String oldPassword) {
     return	userService.updatePassword(id , password , oldPassword);
    	
    }
    
    @PutMapping("reset-password/{id}")
    public User updatePassword (@PathVariable String id , @RequestParam String password  ) {
     return	userService.updatePassword(id , password );
    	
    }
}
