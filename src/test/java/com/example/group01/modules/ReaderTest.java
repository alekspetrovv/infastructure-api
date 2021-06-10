//package com.example.group01.modules;
//
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class ReaderTest {
//
//    @Test
//    void getId() {
//        long id = 1;
//        Reader reader = new Reader();
//        reader.setId(id);
//        assertEquals(id, reader.getId());
//    }
//
//    @Test
//    void getTitle() {
//        Controller controller = new Controller("test", "test", "test");
//        Reader reader = new Reader("test", "long", "test", controller);
//        assertNotNull(reader);
//        assertEquals("test", reader.getRemarks());
//    }
//
//    @Test
//    void getLongitude() {
//        Controller controller = new Controller("test", "test", "test");
//        Reader reader = new Reader("test", "long", "test", controller);
//        assertNotNull(reader);
//        assertEquals("long", reader.getLongitude());
//    }
//
//    @Test
//    void getLatitude() {
//        Controller controller = new Controller("test", "test", "test");
//        Reader reader = new Reader("test", "test", "lat", controller);
//        assertNotNull(reader);
//        assertEquals("lat", reader.getLatitude());
//
//    }
//
//    @Test
//    void getController() {
//        Controller controller = new Controller("controller", "test", "test");
//        Reader reader = new Reader("test", "test", "test", controller);
//        assertNotNull(reader);
//        assertEquals("controller", reader.getController().getRemarks());
//    }
//
//    @Test
//    void setId() {
//        long id = 1;
//        Reader reader = new Reader();
//        reader.setId(id);
//        assertEquals(id, reader.getId());
//    }
//
//    @Test
//    void setTitle() {
//        Controller controller = new Controller("test", "test", "test");
//        Reader reader = new Reader("test", "test", "test", controller);
//        reader.setRemarks("reader");
//        assertNotNull(reader);
//        assertEquals("reader", reader.getRemarks());
//    }
//
//    @Test
//    void setLongitude() {
//        Controller controller = new Controller("test", "test", "test");
//        Reader reader = new Reader("test", "test", "test", controller);
//        reader.setLongitude("125");
//        assertNotNull(reader);
//        assertEquals("125", reader.getLongitude());
//    }
//
//    @Test
//    void setLatitude() {
//        Controller controller = new Controller("test", "test", "test");
//        Reader reader = new Reader("test", "test", "test", controller);
//        reader.setLatitude("130");
//        assertNotNull(reader);
//        assertEquals("130", reader.getLatitude());
//    }
//
//    @Test
//    void setController() {
//        Controller controller = new Controller("controller", "test", "test");
//        Reader reader = new Reader("test", "test", "test", controller);
//        reader.setController(controller);
//        assertNotNull(reader);
//        assertEquals("controller", reader.getController().getRemarks());
//    }
//}