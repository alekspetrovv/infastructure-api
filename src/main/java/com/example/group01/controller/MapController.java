package com.example.group01.controller;

import com.example.group01.modules.FileUtil;
import com.example.group01.modules.Map;
import com.example.group01.modules.Zone;
import com.example.group01.service.MapService;
import com.example.group01.service.ZoneService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

@Controller
@RequestMapping("/maps")
@Validated
@AllArgsConstructor
@CrossOrigin("*")
public class MapController {

    private final MapService mapService;
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
            @NotBlank @RequestParam("title") String title,
            @NotBlank @RequestParam("latitude") String latitude,
            @NotBlank @RequestParam("longitude") String longitude

    ) throws IOException {
        Map map = new Map();
        map.setTitle(title);
        map.setLatitude(latitude);
        map.setLongitude(longitude);
        String fileName = StringUtils.cleanPath(Objects.requireNonNull(multipartFile.getOriginalFilename()));
        map.setImg(fileName);
        Map newMap = mapService.create(map);

        String uploadDir = "img/maps/" + newMap.getId();

        FileUtil.saveFile(uploadDir, fileName, multipartFile);

        return new ResponseEntity<>(newMap, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(
            @RequestParam(value = "file", required = false) MultipartFile multipartFile,
            @PathVariable long id,
            @NotBlank @RequestParam("title") String title,
            @NotBlank @RequestParam("latitude") String latitude,
            @NotBlank @RequestParam("longitude") String longitude
    ) {

        Map map = this.mapService.findMapById(id);
        map.setTitle(title);
        map.setLatitude(latitude);
        map.setLongitude(longitude);

        Map updatedMap = mapService.update(map);

        return new ResponseEntity<>(updatedMap, HttpStatus.CREATED);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Map> delete(@PathVariable("id") Long id) throws IOException {
        mapService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
