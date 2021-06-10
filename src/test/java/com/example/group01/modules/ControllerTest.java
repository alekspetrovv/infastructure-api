//package com.example.group01.modules;
//
//import org.junit.jupiter.api.Test;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class ControllerTest {
//
//    @Test
//    void setId() {
//        long id = 1;
//        Controller controller = new Controller();
//        controller.setId(id);
//        assertEquals(id, controller.getId());
//    }
//
//    @Test
//    void setTitle() {
//        Controller controller = new Controller("test","test","test");
//        assertNotNull(controller);
//        assertEquals("test",controller.getRemarks());
//    }
//
//    @Test
//    void setLongitude() {
//        Controller controller = new Controller("test","250","test");
//        assertNotNull(controller);
//        assertEquals("250",controller.getLongitude());
//    }
//
//    @Test
//    void setLatitude() {
//        Controller controller = new Controller("test","250","260");
//        assertNotNull(controller);
//        assertEquals("260",controller.getLatitude());
//    }
//
//
//    @Test
//    void setReaderList() {
//        Controller controller = new Controller("test","250","test");
//        Reader reader = new Reader("reader","test","test",controller);
//        List<Reader> readerList = new ArrayList<>();
//        readerList.add(reader);
//        controller.setReaderList(readerList);
//        assertNotNull(controller);
//        assertEquals(1,controller.getReaderList().stream().count());
//    }
//
//    @Test
//    void getId() {
//        long id = 1;
//        Controller controller = new Controller();
//        controller.setId(id);
//        assertEquals(id, controller.getId());
//    }
//
//    @Test
//    void getTitle() {
//        Controller controller = new Controller("test","test","test");
//        assertNotNull(controller);
//        assertEquals("test",controller.getRemarks());
//
//    }
//
//    @Test
//    void getLongitude() {
//        Controller controller = new Controller("test","test","test");
//        assertNotNull(controller);
//        assertEquals("test",controller.getLongitude());
//
//    }
//
//    @Test
//    void getLatitude() {
//        Controller controller = new Controller("test","test","test");
//        assertNotNull(controller);
//        assertEquals("test",controller.getLatitude());
//    }
//
//
//    @Test
//    void getReaderList() {
//        Controller controller = new Controller("test","250","test");
//        Reader reader = new Reader("reader","test","test",controller);
//        List<Reader> readerList = new ArrayList<>();
//        readerList.add(reader);
//        controller.setReaderList(readerList);
//        assertNotNull(controller);
//        assertEquals(1,controller.getReaderList().stream().count());
//    }
//}