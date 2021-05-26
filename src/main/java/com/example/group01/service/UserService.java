package com.example.group01.service;

import com.example.group01.exception.MapNotFoundException;
import com.example.group01.exception.UserNotFoundException;
import com.example.group01.modules.ApiUser;
import com.example.group01.modules.request.UserRequest;
import com.example.group01.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    public final UserRepository userRepository;
    public final PasswordEncoder passwordEncoder;



    public ApiUser readUserByEmail(String email) {
        return userRepository.findByUsername(email).orElseThrow(EntityNotFoundException::new);
    }


    public void register(UserRequest userRequest) {
        ApiUser u = new ApiUser();
        Optional<ApiUser> byUsername = userRepository.findByUsername(userRequest.getUsername());
        if (byUsername.isPresent()) {
            throw new RuntimeException("User is already registered.Please use different email.");
        }
        u.setUsername(userRequest.getUsername());
        u.setPassword(passwordEncoder.encode(userRequest.getPassword()));
        u.setFirstName(userRequest.getFirstName());
        u.setLastName(userRequest.getLastName());
        u.setRole(userRequest.getRole());
        userRepository.save(u);
    }

    public List<ApiUser> read() {
        return userRepository.findAll();
    }


    public ApiUser update(ApiUser u) {
        ApiUser existingApiUser = userRepository.getUserById(u.getId());
        if (existingApiUser == null) {
            throw new UserNotFoundException("User does not exist!");
        }
        existingApiUser.setUsername(u.getUsername());
        existingApiUser.setFirstName(u.getFirstName());
        existingApiUser.setLastName(u.getLastName());
        existingApiUser.setPassword(passwordEncoder.encode(u.getPassword()));
        return userRepository.save(existingApiUser);
    }

    public ApiUser findUserById(Long id) {
        ApiUser apiUser = userRepository.getUserById(id);
        if (apiUser == null) {
            throw new MapNotFoundException("User does not exist");
        }
        return apiUser;
    }

    @Transactional
    public void delete(Long id) {
        ApiUser existingApiUser = userRepository.getUserById(id);
        if (existingApiUser == null) {
            throw new UserNotFoundException("User does not exist!");
        }
        userRepository.deleteUserById(id);
    }
}
