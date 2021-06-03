package com.example.group01.modules;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ZoneTest {

    @Test
    void getId() {
        long id = 1;
        Zone zone = new Zone();
        zone.setId(id);
        assertEquals(id, zone.getId());
    }

    @Test
    void getTitle() {
        Map map = new Map("test", "map", "map", "3213");
        Zone zone = new Zone("zone", "test", map);
        assertNotNull(zone);
        assertEquals("zone", zone.getTitle());
    }

    @Test
    void getImg() {
        Map map = new Map("test", "map", "map", "3213");
        String img = "test.png";
        Zone zone = new Zone("zone", img, map);
        assertNotNull(zone);
        assertEquals("/img/zones/0/test.png", zone.getImg());
    }

    @Test
    void getMap() {
        Map map = new Map("test", "map", "map", "3213");
        Zone zone = new Zone("zone", "test", map);
        assertNotNull(zone);
        assertEquals("map", zone.getMap().getLatitude());
    }

    @Test
    void getControllerList() {
        Map map = new Map("test", "map", "map", "3213");
        Zone zone = new Zone("zone", "test", map);
        Controller controller = new Controller();
        List<Controller> controllerList = new ArrayList<>();
        controllerList.add(controller);
        zone.setControllerList(controllerList);
        assertNotNull(zone);
        assertEquals(1, zone.getControllerList().stream().count());
    }

    @Test
    void setId() {
        long id = 1;
        Zone zone = new Zone();
        zone.setId(id);
        assertEquals(id, zone.getId());
    }

    @Test
    void setTitle() {
        Map map = new Map("test", "map", "map", "3213");
        Zone zone = new Zone("zone", "test", map);
        zone.setTitle("zone1");
        assertNotNull(zone);
        assertEquals("zone1", zone.getTitle());
    }

    @Test
    void setImg() {
        String img = "img.png";
        Map map = new Map("test", "map", "map", "3213");
        Zone zone = new Zone("zone", img, map);
        String updateImg = "test.png";
        zone.setImg(updateImg);
        assertNotNull(zone);
        assertEquals("/img/zones/0/test.png", zone.getImg());
    }

    @Test
    void setControllerList() {
        Map map = new Map("test", "map", "map", "3213");
        Zone zone = new Zone("zone", "test", map);
        Controller controller = new Controller();
        List<Controller> controllerList = new ArrayList<>();
        controllerList.add(controller);
        zone.setControllerList(controllerList);
        assertNotNull(zone);
        assertEquals(1, zone.getControllerList().stream().count());
    }
}