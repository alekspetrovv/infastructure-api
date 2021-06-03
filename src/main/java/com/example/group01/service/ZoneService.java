package com.example.group01.service;

import com.example.group01.exception.MapNotFoundException;
import com.example.group01.exception.ZoneNotFoundException;
import com.example.group01.modules.Map;
import com.example.group01.modules.Zone;
import com.example.group01.repository.MapRepository;
import com.example.group01.repository.ZoneRepository;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ZoneService {
    public final ZoneRepository zoneRepository;
    public final MapRepository mapRepository;

    public Zone create(Zone zone) {
        Zone zoneExist = zoneRepository.getZoneByTitle(zone.getTitle());
        if (zoneExist != null) {
            throw new ZoneNotFoundException("Zone with title: " + zone.getTitle() + " already exist!");
        }
        return zoneRepository.save(zone);
    }

    public List<Zone> read() {
        return zoneRepository.findAll();
    }


    public Zone update(Zone zone) {
        return zoneRepository.save(zone);

    }

    public Zone findZoneById(Long id) {
        Zone zone = zoneRepository.getZoneById(id);
        if (zone == null) {
            throw new ZoneNotFoundException("Zone does not exist");
        }
        return zone;
    }


    @Transactional
    public void delete(long id) throws IOException {
        Zone zoneExist = zoneRepository.getZoneById(id);

        if (zoneExist == null) {
            throw new ZoneNotFoundException("Zone does not exist!");
        }

        FileUtils.deleteDirectory(new File("src/main/resources/img/zones/" + id));
        zoneRepository.deleteZoneById(zoneExist.getId());
    }


}
