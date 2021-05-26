package com.example.group01.repository;

import com.example.group01.modules.ApiUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<ApiUser,Long> {
    ApiUser getUserById(long id);
    Optional<ApiUser> findByUsername(String username);
    void deleteUserById(long id);
}
