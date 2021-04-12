package com.example.group01.repository;

import com.example.group01.module.Zone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ZoneRepository extends JpaRepository<Zone, Long> {
    Zone getZoneById(long id);

    Zone getZoneByTitle(String title);

    void deleteZoneById(long id);
}
