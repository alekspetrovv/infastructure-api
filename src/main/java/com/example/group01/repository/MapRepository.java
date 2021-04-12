package com.example.group01.repository;

import com.example.group01.module.Map;
import com.example.group01.module.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MapRepository extends JpaRepository<Map, Long> {
    Map getMapById(long id);

    Map getMapByTitle(String title);

    void deleteMapById(long id);
}
