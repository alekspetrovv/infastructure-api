package com.example.group01.service;

import com.example.group01.exception.MapNotFoundException;
import com.example.group01.modules.Map;
import com.example.group01.repository.MapRepository;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public class MapService {
    public final MapRepository mapRepository;

    @Autowired
    public MapService(MapRepository mapRepository) {
        this.mapRepository = mapRepository;
    }


    public Map create(Map map) {
        Map mapExist = mapRepository.getMapByTitle(map.getTitle());
        if (mapExist != null) {
            throw new MapNotFoundException("Map with title: " + map.getTitle() + " already exist!");
        }
        return mapRepository.save(map);
    }


    public List<Map> read() {
        return mapRepository.findAll();
    }


    public Map update(Map map) {
        Map existingMap = mapRepository.getMapById(map.getId());
        if (existingMap == null) {
            throw new MapNotFoundException("Map does not exist!");
        }
        existingMap.setImg(map.getImg());
        existingMap.setLatitude(map.getLatitude());
        existingMap.setLongitude(map.getLongitude());
        existingMap.setTitle(map.getTitle());
        return existingMap;
//        return mapRepository.save(existingMap);
    }

    public Map findMapById(Long id) {
        Map map = mapRepository.getMapById(id);
        if (map == null) {
            throw new MapNotFoundException("Map does not exist");
        }
        return map;
    }

    @Transactional
    public void delete(long id) throws IOException {
        Map existingMap = mapRepository.getMapById(id);
        if (existingMap == null) {
            throw new MapNotFoundException("Map does not exist!");
        }
        FileUtils.deleteDirectory(new File("img/maps/" + id));
        mapRepository.deleteMapById(id);
    }

}
