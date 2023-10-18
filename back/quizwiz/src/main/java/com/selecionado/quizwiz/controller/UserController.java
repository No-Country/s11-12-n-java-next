package com.selecionado.quizwiz.controller;

import com.selecionado.quizwiz.DTO.request.RoleDtoReq;
import com.selecionado.quizwiz.DTO.request.UserDtoReq;
import com.selecionado.quizwiz.model.Role;
import com.selecionado.quizwiz.model.User;
import com.selecionado.quizwiz.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private IUserService userService;

    @GetMapping(value ="/")
    public ResponseEntity<List<User>> getAllUser(){
        return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/{userId}")
    public ResponseEntity<?> getUserById(@PathVariable Long userId){
        try {
            User user = userService.findById(userId);
            return new ResponseEntity<>(user, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage() , HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<?> saveUser(@RequestBody UserDtoReq userDtoReq){
        User user = userService.save(userDtoReq);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{userId}")
    public ResponseEntity<?> updateUser(@PathVariable Long userId, @RequestBody UserDtoReq userDtoReq){
        try {
            User userUpdate = userService.update(userDtoReq, userId);
            return new ResponseEntity<>(userUpdate, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage() , HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(value = "/{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable Long userId){
        try {
            userService.delete(userId);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage() , HttpStatus.NOT_FOUND);
        }
    }

}
