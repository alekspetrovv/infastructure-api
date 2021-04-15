package com.example.group01.module;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class ZoneTest {

    private Map map;

    @Test
    void setId() {

    }

    @Test
    void createZone() {
        new Zone();
    }

    @Test
    void getId() {
    }

    @Test
    void getTitle() {
        String title = "zone1";
        Zone zone = new Zone("zone1", "32332132", "-32332132", map);
        assertNotNull(zone);
        assertEquals(title, zone.getTitle());
    }

    @Test
    void setTitle() {
        Zone zone = new Zone("zone1", "32332132", "-32332132", map);
        assertNotNull(zone);
        zone.setTitle("test");
        assertEquals("test", zone.getTitle());
    }

    @Test
    void getX_axis() {
        String x_axis = "111";
        Zone zone = new Zone("zone1", "111", "-32332132", map);
        assertNotNull(zone);
        assertEquals(x_axis, zone.getX_axis());
    }

    @Test
    void setX_axis() {
        Zone zone = new Zone("zone1", "111", "-32332132", map);
        assertNotNull(zone);
        zone.setX_axis("112");
        assertEquals("112", zone.getX_axis());
    }

    @Test
    void getY_axis() {
        String y_axis = "112";
        Zone zone = new Zone("zone1", "111", "112", map);
        assertNotNull(zone);
        assertEquals(y_axis, zone.getY_axis());
    }

    @Test
    void setY_axis() {
        Zone zone = new Zone("zone1", "111", "112", map);
        assertNotNull(zone);
        zone.setY_axis("113");
        assertEquals("113", zone.getY_axis());
    }

}