package com.projectclin.demo.controllers;

import com.projectclin.demo.domain.model.User;
import com.projectclin.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    //By: João Gabriel

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity <List<User>> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(userService.findAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable("id") Long id){
        return ResponseEntity.status(HttpStatus.OK).body(userService.findById(id).get());
    }

    @PostMapping
    public ResponseEntity<User> save(@RequestBody User user){
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(user));
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> update(@PathVariable("id") Long User, @RequestBody User user){
        return ResponseEntity.status(HttpStatus.OK).body(userService.update(user));
    }

    @DeleteMapping("/{id}")
    public void destroy(@PathVariable("id") Long id){userService.destroy(id);
    }

}
