package com.example.group01.repository;

import com.example.group01.modules.Point;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PointRepository extends JpaRepository<Point, Long> {

    Point getPointsById(long id);

    void deletePointsById(long id);
}
