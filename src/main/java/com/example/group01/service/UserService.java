package com.example.group01.service;

import com.example.group01.exception.MapNotFoundException;
import com.example.group01.exception.UserNotFoundException;
import com.example.group01.modules.User;
import com.example.group01.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserService {
    public final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User create(User u) {
        User existingUser = userRepository.getUserByEmail(u.getEmail());
        if (existingUser != null) {
            throw new UserNotFoundException("User with email: " + u.getEmail() + " already exist");
        }
        return userRepository.save(u);
    }


    public List<User> read() {
        return userRepository.findAll();
    }


    public User update(User u) {
        User existingUser = userRepository.getUserById(u.getId());
        if (existingUser == null) {
            throw new UserNotFoundException("User does not exist!");
        }
        existingUser.setEmail(u.getEmail());
        existingUser.setFirstName(u.getFirstName());
        existingUser.setLastName(u.getLastName());
        existingUser.setPassword(u.getPassword());
        return userRepository.save(existingUser);
    }

    public User findUserById(Long id) {
        User user = userRepository.getUserById(id);
        if (user == null) {
            throw new MapNotFoundException("User does not exist");
        }
        return user;
    }

    @Transactional
    public void delete(Long id) {
        User existingUser = userRepository.getUserById(id);
        if (existingUser == null) {
            throw new UserNotFoundException("User does not exist!");
        }
        userRepository.deleteUserById(id);
    }
}
