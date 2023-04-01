package com.projectclin.demo.services;

import com.projectclin.demo.domain.model.User;
import com.projectclin.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;
    
    public List<User> findAllUsers(){
        return userRepository.findAll();
    }
    
    public Optional<User> findById(Long id){
        return userRepository.findById(id);
    }
    
    public User save(User user){
        return userRepository.save(user);
    }
    
    public User update(User user){
        return userRepository.save(user);
    }
    
    public void destroy(Long id){
        userRepository.deleteById(id);
    }
}
