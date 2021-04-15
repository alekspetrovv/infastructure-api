package com.example.group01.controller;

import com.example.group01.module.FileUtil;
import com.example.group01.module.Map;
import com.example.group01.service.MapService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

@Controller
@RequestMapping("/maps")
public class MapController {

    private final MapService mapService;


    public MapController(MapService mapService) {
        this.mapService = mapService;
    }

    @GetMapping("")
    public ResponseEntity<List<Map>> getAll() {
        List<Map> maps = mapService.read();
        return new ResponseEntity<>(maps, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Map> getMap(@PathVariable("id") Long id) {
        Map map = mapService.findMapById(id);
        return new ResponseEntity<>(map, HttpStatus.OK);
    }

    @PostMapping(value = "")
    public ResponseEntity<?> create(
            @RequestParam("file") MultipartFile multipartFile,
            @RequestParam("title") String title,
            @RequestParam("latitude") String latitude,
            @RequestParam("longitude") String longitude,
            Map map
    ) throws IOException {

        String fileName = StringUtils.cleanPath(Objects.requireNonNull(multipartFile.getOriginalFilename()));
        map.setImg(fileName);
        Map newMap = mapService.create(map);

        String uploadDir = "img/maps/" + newMap.getId();

        FileUtil.saveFile(uploadDir, fileName, multipartFile);

        return new ResponseEntity<>(newMap, HttpStatus.CREATED);
    }

    @PutMapping("/{map}")
    public ResponseEntity<Map> update(
            @RequestParam(value = "file", required = false) MultipartFile multipartFile,
            @RequestParam("title") String title,
            @RequestParam("latitude") String latitude,
            @RequestParam("longitude") String longitude,
            Map map) {

        Map updatedMap = mapService.update(map);

        return new ResponseEntity<>(updatedMap, HttpStatus.CREATED);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Map> delete(@PathVariable("id") Long id) throws IOException {
        mapService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
