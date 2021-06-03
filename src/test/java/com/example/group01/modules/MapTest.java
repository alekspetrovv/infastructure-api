package com.example.group01.modules;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MapTest {

    @Test
    void getId() {
        long id = 1;
        Map map = new Map();
        map.setId(id);
        assertEquals(id, map.getId());
    }

    @Test
    void setId() {
        long id = 1;
        Map map = new Map();
        map.setId(id);
        assertEquals(id, map.getId());
    }

    @Test
    void createMap() {
        new Map();
    }

    @Test
    void getTitle() {
        String title = "random";
        Map map = new Map("random", "test", "test", "test");
        assertNotNull(map);
        assertEquals(title, map.getTitle());
    }

    @Test
    void setTitle() {
        Map map = new Map("random", "test", "test", "test");
        assertNotNull(map);
        map.setTitle("test");
        assertEquals("test", map.getTitle());
    }

    @Test
    void getImg() {
        String img = "img.png";
        Map map = new Map("random", img, "test", "test");
        assertNotNull(map);
        assertEquals("/img/maps/0/img.png", map.getImg());
    }

    @Test
    void setImg() {
        String img = "img.png";
        Map map = new Map("random", img, "test", "test");
        assertNotNull(map);
        String updateImg = "test.png";
        map.setImg(updateImg);
        assertEquals("/img/maps/0/test.png", map.getImg());
    }

    @Test
    void getLatitude() {
        String lat = "123";
        Map map = new Map("random", "img.png", "123", "test");
        assertNotNull(map);
        assertEquals(lat, map.getLatitude());
    }

    @Test
    void setLatitude() {
        Map map = new Map("random", "img.png", "123", "test");
        assertNotNull(map);
        map.setLatitude("111");
        assertEquals("111", map.getLatitude());
    }

    @Test
    void getLongitude() {
        String lgt = "123";
        Map map = new Map("random", "img.png", "1235", "123");
        assertNotNull(map);
        assertEquals(lgt, map.getLongitude());
    }

    @Test
    void setLongitude() {
        Map map = new Map("random", "img.png", "123", "test");
        assertNotNull(map);
        map.setLongitude("111");
        assertEquals("111", map.getLongitude());
    }
}