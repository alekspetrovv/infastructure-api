package com.example.group01.modules;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReaderTest {

    @Test
    void getId() {
        long id = 1;
        Reader reader = new Reader();
        reader.setId(id);
        assertEquals(id, reader.getId());
    }

    @Test
    void getTitle() {
        Zone zone = new Zone();
        Controller controller = new Controller("test", "test", "test", zone);
        Reader reader = new Reader("test", "long", "test", controller);
        assertNotNull(reader);
        assertEquals("test", reader.getTitle());
    }

    @Test
    void getLongitude() {
        Zone zone = new Zone();
        Controller controller = new Controller("test", "test", "test", zone);
        Reader reader = new Reader("test", "long", "test", controller);
        assertNotNull(reader);
        assertEquals("long", reader.getLongitude());
    }

    @Test
    void getLatitude() {
        Zone zone = new Zone();
        Controller controller = new Controller("test", "test", "test", zone);
        Reader reader = new Reader("test", "test", "lat", controller);
        assertNotNull(reader);
        assertEquals("lat", reader.getLatitude());

    }

    @Test
    void getController() {
        Zone zone = new Zone();
        Controller controller = new Controller("controller", "test", "test", zone);
        Reader reader = new Reader("test", "test", "test", controller);
        assertNotNull(reader);
        assertEquals("controller", reader.getController().getTitle());
    }

    @Test
    void setId() {
        long id = 1;
        Reader reader = new Reader();
        reader.setId(id);
        assertEquals(id, reader.getId());
    }

    @Test
    void setTitle() {
        Zone zone = new Zone();
        Controller controller = new Controller("test", "test", "test", zone);
        Reader reader = new Reader("test", "test", "test", controller);
        reader.setTitle("reader");
        assertNotNull(reader);
        assertEquals("reader", reader.getTitle());
    }

    @Test
    void setLongitude() {
        Zone zone = new Zone();
        Controller controller = new Controller("test", "test", "test", zone);
        Reader reader = new Reader("test", "test", "test", controller);
        reader.setLongitude("125");
        assertNotNull(reader);
        assertEquals("125", reader.getLongitude());
    }

    @Test
    void setLatitude() {
        Zone zone = new Zone();
        Controller controller = new Controller("test", "test", "test", zone);
        Reader reader = new Reader("test", "test", "test", controller);
        reader.setLatitude("130");
        assertNotNull(reader);
        assertEquals("130", reader.getLatitude());
    }

    @Test
    void setController() {
        Zone zone = new Zone();
        Controller controller = new Controller("controller", "test", "test", zone);
        Reader reader = new Reader("test", "test", "test", controller);
        reader.setController(controller);
        assertNotNull(reader);
        assertEquals("controller", reader.getController().getTitle());
    }
}