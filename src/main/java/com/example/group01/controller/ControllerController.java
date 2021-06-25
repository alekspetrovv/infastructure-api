package com.example.group01.controller;


import com.example.group01.modules.Controller;
import com.example.group01.service.ControllerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@org.springframework.stereotype.Controller
@RequestMapping("/controllers")
@Validated
@AllArgsConstructor
@CrossOrigin("*")
public class ControllerController {

    private final ControllerService controllerService;

    @GetMapping("")
    public ResponseEntity<List<Controller>> getAll() {

        List<Controller> controllerList = controllerService.read();
        return new ResponseEntity<>(controllerList, HttpStatus.OK);

    }


    @GetMapping("/{id}")
    public ResponseEntity<Controller> getController(@PathVariable("id") Long id) {
        Controller getController = controllerService.findControllerById(id);
        return new ResponseEntity<>(getController, HttpStatus.OK);
    }

//    @GetMapping("/{id}/readers")
//    public ResponseEntity<?> getControllerReaders(@PathVariable("id") Long id) {
//        Controller controller = controllerService.findControllerById(id);
//        return new ResponseEntity<>(controller.getReaderList(), HttpStatus.OK);
//    }


    @PostMapping(value = "")
    public ResponseEntity<?> create(
            @RequestParam(value = "remarks", required = false) String remarks,
            @NotBlank @RequestParam("latitude") String latitude,
            @NotBlank @RequestParam("longitude") String longitude,
            @RequestParam(value = "status", required = false) String status,
            @RequestParam(value = "enabled", required = false) Boolean enabled,
            @RequestParam(value = "fromTime", required = false) String fromTime,
            @RequestParam(value = "untilTime", required = false) String untilTime,
            @RequestParam("mapId") Long mapId

    ) {
        Controller controller = new Controller();
        controller.setRemarks(remarks);
        controller.setStatus(status);
        controller.setEnabled(enabled);
        if(fromTime != null) { controller.setFromTime(LocalDateTime.parse("1970-01-01T" + fromTime)); }
        if(untilTime != null) { controller.setUntilTime(LocalDateTime.parse("1970-01-01T" + untilTime)); }
        controller.setLatitude(latitude);
        controller.setLongitude(longitude);
        controller.setMapId(mapId);

        Controller newController = controllerService.create(controller);
        return new ResponseEntity<>(newController, HttpStatus.CREATED);
    }


    @PutMapping("/{id}")
    public ResponseEntity<?> update(
            @PathVariable long id,
            @RequestParam(value = "remarks", required = false) String remarks,
            @RequestParam(value = "latitude", required = false) String latitude,
            @RequestParam(value = "longitude", required = false) String longitude,
            @RequestParam(value = "status", required = false) String status,
            @RequestParam(value = "enabled", required = false) Boolean enabled,
            @RequestParam(value = "fromTime", required = false) String fromTime,
            @RequestParam(value = "untilTime", required = false) String untilTime
    ) {
        Controller controller = this.controllerService.findControllerById(id);
        if(remarks != null) {controller.setRemarks(remarks);}
        if(status != null) {controller.setStatus(status);}
        if(enabled != null) {controller.setEnabled(enabled);}
        if(fromTime != null) {controller.setFromTime(LocalDateTime.parse("1970-01-01T" + fromTime)); }
        if(untilTime != null) {controller.setUntilTime(LocalDateTime.parse("1970-01-01T" + untilTime)); }
        if(latitude != null) {controller.setLatitude(latitude);}
        if(longitude != null) {controller.setLongitude(longitude);}
        Controller updatedController = controllerService.update(controller);

        return new ResponseEntity<>(updatedController, HttpStatus.CREATED);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Controller> delete(@PathVariable("id") Long id) {
        controllerService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
