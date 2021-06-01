package com.example.group01.repository;

import com.example.group01.modules.Map;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface MapRepository extends JpaRepository<Map, Long> {
    Map getMapById(long id);

    Map getMapByTitle(String title);

    void deleteMapById(long id);
}
