package com.example.group01.controller;

import com.example.group01.modules.Map;
import com.example.group01.modules.User;
import com.example.group01.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import java.util.List;

@RestController
@RequestMapping("/user")
@Validated
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

    @PostMapping(value = "")
    public ResponseEntity<User> create(
            @NotBlank @RequestParam("email") String email,
            @NotBlank @RequestParam("password") String password,
            @NotBlank @RequestParam("firstName") String firstName,
            @NotBlank @RequestParam("lastName") String lastName
    ) {
        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        User newUser = userService.create(user);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }


    @PutMapping("/{id}")
    public ResponseEntity<User> update(
            @NotBlank @RequestParam("email") String email,
            @NotBlank @RequestParam("password") String password,
            @NotBlank @RequestParam("firstName") String firstName,
            @NotBlank @RequestParam("lastName") String lastName,
            @NotBlank @PathVariable long id
    ) {
        User user = userService.findUserById(id);
        user.setEmail(email);
        user.setPassword(password);
        user.setFirstName(firstName);
        user.setLastName(lastName);

        User updatedUser = userService.update(user);
        return new ResponseEntity<>(updatedUser, HttpStatus.CREATED);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Map> delete(@PathVariable("id") Long id) {
        userService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
