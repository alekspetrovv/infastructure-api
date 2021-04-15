package com.example.group01.controller;

import com.example.group01.module.Map;
import com.example.group01.module.User;
import com.example.group01.service.MapService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/map")
public class MapController {

    private final MapService mapService;


    public MapController(MapService mapService) {
        this.mapService = mapService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Map>> getAll() {
        List<Map> maps = mapService.read();
        return new ResponseEntity<>(maps, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Map> getMap(@PathVariable("id") Long id) {
        Map getMap = mapService.findMapById(id);
        return new ResponseEntity<>(getMap, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Map> create(@RequestBody Map map) {
        Map newMap = mapService.create(map);
        return new ResponseEntity<>(newMap, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Map> update(@RequestBody Map map) {
        Map updateMap = mapService.update(map);
        return new ResponseEntity<>(updateMap, HttpStatus.CREATED);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Map> delete(@PathVariable("id") Long id) {
        mapService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
