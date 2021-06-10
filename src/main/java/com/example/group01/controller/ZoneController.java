package com.example.group01.controller;

import com.example.group01.exception.MapNotFoundException;
import com.example.group01.modules.FileUtil;
import com.example.group01.modules.Map;
import com.example.group01.modules.Zone;
import com.example.group01.service.MapService;
import com.example.group01.service.ZoneService;
import lombok.AllArgsConstructor;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotBlank;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

@Controller
@RequestMapping("/zones")
@AllArgsConstructor
public class ZoneController {

    private final ZoneService zoneService;

    @GetMapping("")
    public ResponseEntity<List<Zone>> getAll() {
        List<Zone> zones = zoneService.read();
        return new ResponseEntity<>(zones, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Zone> getZone(@PathVariable("id") Long id) {
        Zone getZone = zoneService.findZoneById(id);
        return new ResponseEntity<>(getZone, HttpStatus.OK);
    }


    @GetMapping("/{id}/points")
    public ResponseEntity<?> getZonePoints(@PathVariable("id") Long id) {
        Zone zone = zoneService.findZoneById(id);
        return new ResponseEntity<>(zone.getPointsList(), HttpStatus.OK);
    }

    @PostMapping(value = "")
    public ResponseEntity<?> create(
            @RequestParam("file") MultipartFile multipartFile,
            @NotBlank @RequestParam("title") String title,
            @NotBlank @RequestParam("map_id") Map map
    ) throws IOException {
        Zone zone = new Zone();
        zone.setTitle(title);
        zone.setMap(map);
        String fileName = StringUtils.cleanPath(Objects.requireNonNull(multipartFile.getOriginalFilename()));
        zone.setImg(fileName);
        Zone newZone = zoneService.create(zone);

        String uploadDir = "src/main/resources/img/zones/" + newZone.getId();

        FileUtil.saveFile(uploadDir, fileName, multipartFile);

        return new ResponseEntity<>(newZone, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(
            @RequestParam(value = "file", required = false) MultipartFile multipartFile,
            @PathVariable long id,
            @NotBlank @RequestParam("title") String title,
            @NotBlank @RequestParam(value = "map_id", required = false) Map map

    ) throws IOException {
        Zone zone = zoneService.findZoneById(id);
        zone.setTitle(title);
        zone.setMap(map);

        if (multipartFile != null) {
            String fileName = StringUtils.cleanPath(Objects.requireNonNull(multipartFile.getOriginalFilename()));
            FileUtils.deleteDirectory(new File("src/main/resources/img/zones/" + zone.getId()));
            String uploadDir = "src/main/resources/img/zones/" + zone.getId();
            zone.setImg(fileName);
            FileUtil.saveFile(uploadDir, fileName, multipartFile);
        }


        Zone updatedZone = zoneService.update(zone);

        return new ResponseEntity<>(updatedZone, HttpStatus.CREATED);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Zone> delete(@PathVariable("id") Long id) throws IOException {
        zoneService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
