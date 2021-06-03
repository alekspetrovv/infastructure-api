package com.example.group01.modules;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PointTest {

    @Test
    void setId() {
        long id = 1;
        Point points = new Point();
        points.setId(id);
        assertEquals(id, points.getId());
    }

    @Test
    void setLongitude() {
        Zone zone = new Zone();
        Point points = new Point("200", "300", zone);
        points.setLongitude("250");
        assertNotNull(points);
        assertEquals("250", points.getLongitude());
    }

    @Test
    void setLatitude() {
        Zone zone = new Zone();
        Point points = new Point("200", "300", zone);
        points.setLatitude("350");
        assertNotNull(points);
        assertEquals("350", points.getLatitude());
    }

    @Test
    void setZone() {
        Map map1 = new Map();
        Map map2 = new Map();
        Zone zone1 = new Zone("zone1", "test", map1);
        Zone zone2 = new Zone("zone2", "test", map2);
        Point points = new Point("200", "300", zone1);
        points.setZone(zone2);
        assertNotNull(points);
        assertEquals("zone2", points.getZone().getTitle());
    }

    @Test
    void getId() {
        long id = 1;
        Point points = new Point();
        points.setId(id);
        assertEquals(id, points.getId());
    }

    @Test
    void getLongitude() {
        Zone zone = new Zone();
        Point points = new Point("200", "300", zone);
        assertNotNull(points);
        assertEquals("200", points.getLongitude());
    }

    @Test
    void getLatitude() {
        Zone zone = new Zone();
        Point points = new Point("200", "300", zone);
        assertNotNull(points);
        assertEquals("300", points.getLatitude());
    }

    @Test
    void getZone() {
        Map map1 = new Map();
        Zone zone1 = new Zone("zone1", "test", map1);
        Point points = new Point("200", "300", zone1);
        assertNotNull(points);
        assertEquals("zone1", points.getZone().getTitle());
    }
}