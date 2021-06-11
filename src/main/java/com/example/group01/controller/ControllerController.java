package com.example.group01.controller;


import com.example.group01.modules.Controller;
import com.example.group01.service.ControllerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
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
            @NotBlank @RequestParam(value = "remarks", required = false) String remarks,
            @NotBlank @RequestParam("latitude") String latitude,
            @NotBlank @RequestParam("longitude") String longitude,
            @NotBlank @RequestParam(value = "status", required = false) String status,
            @RequestParam(value = "enabled", required = false) Boolean enabled,
            @RequestParam(value = "fromTime", required = false) Date fromTime,
            @RequestParam(value = "untilTime", required = false) Date untilTime

    ) {
        Controller controller = new Controller();
        controller.setRemarks(remarks);
        controller.setStatus(status);
        controller.setEnabled(enabled);
//        controller.setFromTime(fromTime);
//        controller.setUntilTime(untilTime);
        controller.setLatitude(latitude);
        controller.setLongitude(longitude);
        Controller newController = controllerService.create(controller);
        return new ResponseEntity<>(newController, HttpStatus.CREATED);
    }


    @PutMapping("/{id}")
    public ResponseEntity<?> update(
            @PathVariable long id,
            @NotBlank @RequestParam(value = "remarks", required = false) String remarks,
            @NotBlank @RequestParam("latitude") String latitude,
            @NotBlank @RequestParam("longitude") String longitude,
            @NotBlank @RequestParam(value = "status", required = false) String status,
            @RequestParam(value = "enabled", required = false) Boolean enabled,
            @RequestParam(value = "fromTime", required = false) Date fromTime,
            @RequestParam(value = "untilTime", required = false) Date untilTime
    ) {
        Controller controller = this.controllerService.findControllerById(id);
        controller.setRemarks(remarks);
        controller.setStatus(status);
        controller.setEnabled(enabled);
        controller.setFromTime(fromTime);
        controller.setUntilTime(untilTime);
        controller.setLatitude(latitude);
        controller.setLongitude(longitude);
        Controller updatedController = controllerService.update(controller);

        return new ResponseEntity<>(updatedController, HttpStatus.CREATED);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Controller> delete(@PathVariable("id") Long id) {
        controllerService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
