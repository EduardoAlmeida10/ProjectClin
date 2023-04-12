package com.projectclin.demo.services;

import com.projectclin.demo.domain.model.User;
import com.projectclin.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    //By: João Gabriel

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MailServiceImpl mailService;
    
    public List<User> findAllUsers(){
        return userRepository.findAll();
    }
    
    public Optional<User> findById(Long id){
        return userRepository.findById(id);
    }
    
    public User save(User user) throws Exception {
        String token = UUID.randomUUID().toString();
        user.setConfirmationToken(token);
        mailService.sendEmail(user.getEmail(), "confirmation", "localhost:8080/api/v1/users/"+token);
        user.setIsConfirmed(false);
        return userRepository.save(user);
    }
    
    public User update(User user){
        return userRepository.save(user);
    }
    
    public void destroy(Long id){
        userRepository.deleteById(id);
    }

    public Boolean existsByConfirmationToken(String token){
        Boolean exists = userRepository.existsByConfirmationToken(token);
        if(exists){
            User user = userRepository.getUserByConfirmationToken(token);
            user.setIsConfirmed(true);
            userRepository.save(user);
        }
        return exists;
    }
}
