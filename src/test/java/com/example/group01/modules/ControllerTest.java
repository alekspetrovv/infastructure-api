package com.example.group01.modules;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ControllerTest {

    @Test
    void setId() {
        long id = 1;
        Controller controller = new Controller();
        controller.setId(id);
        assertEquals(id, controller.getId());
    }

    @Test
    void setTitle() {
        Map map = new Map();
        Zone zone = new Zone("test","test",map);
        Controller controller = new Controller("test","test","test",zone);
        assertNotNull(controller);
        assertEquals("test",controller.getTitle());
    }

    @Test
    void setLongitude() {
        Map map = new Map();
        Zone zone = new Zone("test","test",map);
        Controller controller = new Controller("test","250","test",zone);
        assertNotNull(controller);
        assertEquals("250",controller.getLongitude());
    }

    @Test
    void setLatitude() {
        Map map = new Map();
        Zone zone = new Zone("test","test",map);
        Controller controller = new Controller("test","250","260",zone);
        assertNotNull(controller);
        assertEquals("260",controller.getLatitude());
    }

    @Test
    void setZone() {
        Map map = new Map();
        Zone zone = new Zone("test","test",map);
        Controller controller = new Controller("test","test","test",zone);
        assertNotNull(controller);
        assertEquals("test",controller.getZone().getTitle());
    }

    @Test
    void setReaderList() {
        Map map = new Map();
        Zone zone = new Zone("test","test",map);
        Controller controller = new Controller("test","250","test",zone);
        Reader reader = new Reader("reader","test","test",controller);
        List<Reader> readerList = new ArrayList<>();
        readerList.add(reader);
        controller.setReaderList(readerList);
        assertNotNull(controller);
        assertEquals(1,controller.getReaderList().stream().count());
    }

    @Test
    void getId() {
        long id = 1;
        Controller controller = new Controller();
        controller.setId(id);
        assertEquals(id, controller.getId());
    }

    @Test
    void getTitle() {
        Map map = new Map();
        Zone zone = new Zone("test","test",map);
        Controller controller = new Controller("test","test","test",zone);
        assertNotNull(controller);
        assertEquals("test",controller.getTitle());

    }

    @Test
    void getLongitude() {
        Map map = new Map();
        Zone zone = new Zone("test","test",map);
        Controller controller = new Controller("test","test","test",zone);
        assertNotNull(controller);
        assertEquals("test",controller.getLongitude());

    }

    @Test
    void getLatitude() {
        Map map = new Map();
        Zone zone = new Zone("test","test",map);
        Controller controller = new Controller("test","test","test",zone);
        assertNotNull(controller);
        assertEquals("test",controller.getLatitude());
    }

    @Test
    void getZone() {
        Map map = new Map();
        Zone zone = new Zone("zone","test",map);
        Controller controller = new Controller("test","test","test",zone);
        controller.setZone(zone);
        assertNotNull(controller);
        assertEquals("zone",controller.getZone().getTitle());

    }

    @Test
    void getReaderList() {
        Map map = new Map();
        Zone zone = new Zone("test","test",map);
        Controller controller = new Controller("test","250","test",zone);
        Reader reader = new Reader("reader","test","test",controller);
        List<Reader> readerList = new ArrayList<>();
        readerList.add(reader);
        controller.setReaderList(readerList);
        assertNotNull(controller);
        assertEquals(1,controller.getReaderList().stream().count());
    }
}