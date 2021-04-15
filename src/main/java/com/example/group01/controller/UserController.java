package com.example.group01.controller;

import com.example.group01.module.Map;
import com.example.group01.module.User;
import com.example.group01.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<User>> getAll() {
        List<User> user = userService.read();
        return new ResponseEntity<>(user, HttpStatus.OK);
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


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Map> delete(@PathVariable("id") Long id) {
        userService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
