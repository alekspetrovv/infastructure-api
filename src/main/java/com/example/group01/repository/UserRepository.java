package com.example.group01.repository;

import com.example.group01.module.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    User getUserById(long id);
    User getUserByEmail(String email);
    void deleteUserById(long id);
}
