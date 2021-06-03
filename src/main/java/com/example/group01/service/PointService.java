package com.example.group01.service;


import com.example.group01.exception.PointsNotFoundException;
import com.example.group01.modules.Point;
import com.example.group01.repository.PointRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@AllArgsConstructor
public class PointService {

    private final PointRepository pointRepository;

    public Point create(Point point) {
        return pointRepository.save(point);
    }

    public List<Point> read() {
        return pointRepository.findAll();
    }


    public Point update(Point point) {
        return pointRepository.save(point);
    }


    public Point findPointById(long id) {

        Point points = pointRepository.getPointsById(id);

        if (points == null) {
            throw new PointsNotFoundException("Points are not found!");
        }
        return points;
    }


    @Transactional
    public void delete(long id) {

        Point existingPoints = findPointById(id);

        if (existingPoints != null) {
            pointRepository.deletePointsById(id);
        }

        return;

    }


}
