package com.example.group01.controller;

import com.example.group01.modules.Map;
import com.example.group01.modules.ApiUser;
import com.example.group01.modules.request.UserRequest;
import com.example.group01.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
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
    public ResponseEntity<List<ApiUser>> getAll() {
        List<ApiUser> apiUser = userService.read();
        return new ResponseEntity<>(apiUser, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiUser> getUser(@PathVariable("id") Long id) {
        ApiUser getApiUser = userService.findUserById(id);
        return new ResponseEntity<>(getApiUser, HttpStatus.OK);
    }


    @PostMapping("/register")
    public ResponseEntity create(@RequestBody UserRequest userRequest) {
        userService.register(userRequest);
        return ResponseEntity.ok().build();
    }


    @PutMapping("/{id}")
    public ResponseEntity<ApiUser> update(
            @NotBlank @RequestParam("username") String username,
            @NotBlank @RequestParam("password") String password,
            @NotBlank @RequestParam("firstName") String firstName,
            @NotBlank @RequestParam("lastName") String lastName,
            @NotNull @PathVariable long id
    ) {
        ApiUser apiUser = userService.findUserById(id);
        apiUser.setUsername(username);
        apiUser.setPassword(password);
        apiUser.setFirstName(firstName);
        apiUser.setLastName(lastName);

        ApiUser updatedApiUser = userService.update(apiUser);
        return new ResponseEntity<>(updatedApiUser, HttpStatus.CREATED);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Map> delete(@PathVariable("id") Long id) {
        userService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
