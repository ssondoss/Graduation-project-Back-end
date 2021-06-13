package com.graduation.plusPlusCv.service;

import com.graduation.plusPlusCv.adapter.repo.UserRepo;
import com.graduation.plusPlusCv.models.User;
import com.graduation.plusPlusCv.service.DTOs.UserDTO;
import com.graduation.plusPlusCv.service.DTOs.UserRegistrationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
public class UserService {

    @Autowired
    UserRepo userRepo;

    public UserDTO login(String email, String password){
        Optional<User> userByEmailAndPassword = userRepo.findUserByEmailAndPassword(email.toLowerCase(), password);
        if(!userByEmailAndPassword.isPresent()){
            throw new RuntimeException("WRONG_EMAIL_OR_PASSWORD");
        }
        User user = userByEmailAndPassword.get();
        UserDTO userDTO = UserDTO.builder().id(user.getId()).fullName(user.getFullName()).email(user.getEmail()).build();
        return userDTO;
    }

    public boolean registerNewUser(UserRegistrationDTO userRegistrationDTO) {
    	 Optional<User> userByEmail = userRepo.findUserByEmail(userRegistrationDTO.getEmail().toLowerCase());
    	 
    	 if(userByEmail.isPresent()) {
    		 throw new RuntimeException("EMAIL USED");
    	 }
    	
        User user =User.builder().
                id(UUID.randomUUID().toString()).
                email(userRegistrationDTO.getEmail().toLowerCase()).
                password((userRegistrationDTO.getPassword())).
                fullName(userRegistrationDTO.getFullName()).
                joinedAt(LocalDateTime.now()).
                build();
        
        Optional<User> user1 = userRepo.addUser(user);
        if (user1.isPresent())
            return true;
        else
            return false;
    }

    public List<User> getAllUsers(){
        return userRepo.getAllUsers();
    }

    public User getUserById(String id){
        Optional<User> userById = userRepo.getUserById(id);
        if(!userById.isPresent()){
            throw new RuntimeException("USER_NOT_FOUND");
        }
        return userById.get();

    }

	public User updateUser(String id, String name) {
		Optional<User> user= userRepo.getUserById(id);
		if(user.isPresent()) {
			User realUser=user.get();
			realUser.setFullName(name);
			 userRepo.addUser(realUser);
			 return realUser;
		}
		
		
		return null;
	}

	public User updatePassword(String id, String password , String oldPassword) {
		
		Optional<User> user= userRepo.getUserById(id);
		if(user.isPresent()) {
			
			User realUser=user.get();
			if(realUser.getPassword().equals(oldPassword) ) {
			realUser.setPassword(password);
			 userRepo.addUser(realUser);
			 return realUser;
			}
			else throw new RuntimeException("INCORRECT_PASSWROD");
		}
				return null;
	}
	
public User updatePassword(String id, String password ) {
		
		Optional<User> user= userRepo.getUserById(id);
		if(user.isPresent()) {
			
			User realUser=user.get();
			
			realUser.setPassword(password);
			 userRepo.addUser(realUser);
			 return realUser;
			
		}
				return null;
	}
}
