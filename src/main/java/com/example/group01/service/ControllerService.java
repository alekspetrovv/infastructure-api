package com.example.group01.service;

import com.example.group01.exception.ControllerNotFoundException;
import com.example.group01.modules.Controller;
import com.example.group01.repository.ControllerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@AllArgsConstructor
public class ControllerService {

    private final ControllerRepository controllerRepository;


    public Controller create(Controller controller) {
        return controllerRepository.save(controller);
    }


    public List<Controller> read() {
        return controllerRepository.findAll();
    }


    public Controller update(Controller controller) {
       return controllerRepository.save(controller);
    }


    public Controller findControllerById(Long id) {
        Controller controller = controllerRepository.getControllerById(id);
        if (controller == null) {
            throw new ControllerNotFoundException("Controller does not exist");
        }
        return controller;
    }

    @Transactional
    public void delete(long id) {
        Controller existingController = controllerRepository.getControllerById(id);
        if (existingController == null) {
            throw new ControllerNotFoundException("Controller does not exist!");
        }
        controllerRepository.deleteControllerById(id);
    }

}
