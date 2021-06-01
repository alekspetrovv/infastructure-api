package com.example.group01.controller;


import com.example.group01.modules.Reader;
import com.example.group01.modules.Zone;
import com.example.group01.service.ReaderService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import java.awt.print.Pageable;
import java.util.List;


@Controller
@RequestMapping("/readers")
@Validated
@AllArgsConstructor
@CrossOrigin("*")
public class ReaderController {


    private final ReaderService readerService;

    @GetMapping("")
    public ResponseEntity<List<Reader>> getAll() {
        List<Reader> readerList = readerService.read();
        return new ResponseEntity<>(readerList, HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Reader> getReader(@PathVariable("id") Long id) {
        Reader getReader = readerService.findReaderById(id);
        return new ResponseEntity<>(getReader, HttpStatus.OK);
    }


    @PostMapping(value = "")
    public ResponseEntity<?> create(
            @NotBlank @RequestParam("title") String title,
            @NotBlank @RequestParam("latitude") String latitude,
            @NotBlank @RequestParam("longitude") String longitude,
            @RequestParam("controller_id") com.example.group01.modules.Controller controller

    ) {
        Reader reader = new Reader();
        reader.setTitle(title);
        reader.setLatitude(latitude);
        reader.setLongitude(longitude);
        reader.setController(controller);


        Reader newReader = readerService.create(reader);
        return new ResponseEntity<>(newReader, HttpStatus.CREATED);
    }


    @PutMapping("/{id}")
    public ResponseEntity<?> update(
            @PathVariable long id,
            @NotBlank @RequestParam("title") String title,
            @NotBlank @RequestParam("latitude") String latitude,
            @NotBlank @RequestParam("longitude") String longitude,
            @RequestParam(value = "controller_id", required = false) com.example.group01.modules.Controller controller
    ) {
        Reader reader = this.readerService.findReaderById(id);
        reader.setTitle(title);
        reader.setLatitude(latitude);
        reader.setLongitude(longitude);
        reader.setController(controller);


        Reader updatedReader = readerService.update(reader);
        return new ResponseEntity<>(updatedReader, HttpStatus.CREATED);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Reader> delete(@PathVariable("id") Long id) {
        readerService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
