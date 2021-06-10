package com.example.group01.repository;

import com.example.group01.modules.Controller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ControllerRepository extends JpaRepository<Controller, Long> {

    Controller getControllerById(long id);
    void deleteControllerById(long id);

}
