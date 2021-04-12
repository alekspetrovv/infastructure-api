package com.example.group01.controller;

import com.example.group01.module.User;
import com.example.group01.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<User>> getAll() {
        List<User> users = userService.read();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable("id") Long id) {
        User getUser = userService.findUserById(id);
        return new ResponseEntity<>(getUser, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<User> create(@RequestBody User user) {
        User newUser = userService.create(user);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<User> update(@RequestBody User user) {
        User updateUser = userService.update(user);
        return new ResponseEntity<>(updateUser, HttpStatus.CREATED);
    }


    @Transactional
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<User> delete(@PathVariable("id") Long id) {
        userService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
