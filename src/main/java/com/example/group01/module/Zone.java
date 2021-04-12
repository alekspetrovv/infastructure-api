package com.example.group01.module;

import javax.persistence.*;

@Entity
public class Zone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private long id;
    private String title;
    private String x_axis;
    private String y_axis;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "map_id", referencedColumnName = "id")
    private Map map;

    public Zone(String title, String x_axis, String y_axis, Map map) {
        this.title = title;
        this.x_axis = x_axis;
        this.y_axis = y_axis;
        this.map = map;
    }


    public Zone() {

    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getX_axis() {
        return x_axis;
    }

    public void setX_axis(String x_axis) {
        this.x_axis = x_axis;
    }

    public String getY_axis() {
        return y_axis;
    }

    public void setY_axis(String y_axis) {
        this.y_axis = y_axis;
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }


}
