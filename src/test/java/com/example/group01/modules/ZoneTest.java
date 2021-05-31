package com.example.group01.modules;

import org.junit.jupiter.api.Test;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
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
        Zone zone = new Zone("zone1", "test" ,map);
        assertNotNull(zone);
        assertEquals(title, zone.getTitle());
    }

    @Test
    void setTitle() {
        Zone zone = new Zone("zone1","test", map);
        assertNotNull(zone);
        zone.setTitle("test");
        assertEquals("test", zone.getTitle());
    }



}