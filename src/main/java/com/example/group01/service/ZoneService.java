package com.example.group01.service;

import com.example.group01.exception.ZoneNotFoundException;
import com.example.group01.modules.Map;
import com.example.group01.modules.Zone;
import com.example.group01.repository.ZoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ZoneService {
    public final ZoneRepository zoneRepository;

    @Autowired
    public ZoneService(ZoneRepository zoneRepository) {
        this.zoneRepository = zoneRepository;
    }

    public Zone create(Zone zone) {
        Zone zoneExist = zoneRepository.getZoneByTitle(zone.getTitle());
        if (zoneExist != null) {
            throw new ZoneNotFoundException("Zone with title: " + zone.getTitle() + " already exist!");
        }
        //TODO: Find if map exist

        return zoneRepository.save(zone);
    }

    public List<Zone> read() {
        return zoneRepository.findAll();
    }


    public Zone update(Zone zone) {
        Zone zoneExist = zoneRepository.getZoneById(zone.getId());
        if (zoneExist == null) {
            throw new ZoneNotFoundException("Zone does not exist!");
        }

        zoneExist.setTitle(zone.getTitle());
        zoneExist.setX_axis(zone.getX_axis());
        zoneExist.setY_axis(zone.getY_axis());

        //TODO: Find if map exist

        zoneExist.setMap(zone.getMap());

        return zoneRepository.save(zoneExist);

    }

    public Zone findZoneById(Long id) {
        Zone zone = zoneRepository.getZoneById(id);
        if (zone == null) {
            throw new ZoneNotFoundException("Zone does not exist");
        }
        return zone;
    }


    @Transactional
    public void delete(long id) {
        Zone zoneExist = zoneRepository.getZoneById(id);
        if (zoneExist == null) {
            throw new ZoneNotFoundException("Zone does not exist!");
        }
        zoneRepository.deleteZoneById(zoneExist.getId());
    }


}
