package com.example.group01.controller;

import com.example.group01.module.Map;
import com.example.group01.module.Zone;
import com.example.group01.service.MapService;
import com.example.group01.service.ZoneService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/zone")
public class ZoneController {

    private final ZoneService zoneService;

    public ZoneController(ZoneService zoneService) {
        this.zoneService = zoneService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Zone>> getAll() {
        List<Zone> zones = zoneService.read();
        return new ResponseEntity<>(zones, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Zone> getZone(@PathVariable("id") Long id) {
        Zone getZone = zoneService.findZoneById(id);
        return new ResponseEntity<>(getZone, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Zone> create(@RequestBody Zone zone) {
        Zone newZone = zoneService.create(zone);
        return new ResponseEntity<>(newZone, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Zone> update(@RequestBody Zone zone) {
        Zone updateZone = zoneService.update(zone);
        return new ResponseEntity<>(updateZone, HttpStatus.CREATED);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Map> delete(@PathVariable("id") Long id) {
        zoneService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
