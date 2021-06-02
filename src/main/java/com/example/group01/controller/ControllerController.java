package com.example.group01.controller;


import com.example.group01.modules.Controller;
import com.example.group01.modules.Zone;
import com.example.group01.service.ControllerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
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

    @GetMapping("/{id}/readers")
    public ResponseEntity<?> getControllerReaders(@PathVariable("id") Long id) {
        Controller controller = controllerService.findControllerById(id);
        return new ResponseEntity<>(controller.getReaderList(), HttpStatus.OK);
    }



    @PostMapping(value = "")
    public ResponseEntity<?> create(
            @NotBlank @RequestParam("title") String title,
            @NotBlank @RequestParam("latitude") String latitude,
            @NotBlank @RequestParam("longitude") String longitude,
            @RequestParam("zone_id") Zone zone

    ) {
        Controller controller = new Controller();
        controller.setTitle(title);
        controller.setLatitude(latitude);
        controller.setLongitude(longitude);
        controller.setZone(zone);
        Controller newController = controllerService.create(controller);
        return new ResponseEntity<>(newController, HttpStatus.CREATED);
    }




    @PutMapping("/{id}")
    public ResponseEntity<?> update(
            @PathVariable long id,
            @NotBlank @RequestParam("title") String title,
            @NotBlank @RequestParam("latitude") String latitude,
            @NotBlank @RequestParam("longitude") String longitude,
            @RequestParam(value = "zone_id", required = false) Zone zone
    ) {
        Controller controller = this.controllerService.findControllerById(id);
        controller.setTitle(title);
        controller.setLatitude(latitude);
        controller.setLongitude(longitude);
        controller.setZone(zone);

        Controller updatedController = controllerService.update(controller);

        return new ResponseEntity<>(updatedController, HttpStatus.CREATED);
    }




    @DeleteMapping("/{id}")
    public ResponseEntity<Controller> delete(@PathVariable("id") Long id){
        controllerService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
