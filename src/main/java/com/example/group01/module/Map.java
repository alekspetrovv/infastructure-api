package com.example.group01.module;

import javax.persistence.*;

@Entity
public class Map {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private long id;
    private String title;
    private String img;
    private String latitude;
    private String longitude;


    public Map(String title, String img, String latitude, String longitude) {
        this.title = title;
        this.img = img;
        this.latitude = latitude;
        this.longitude = longitude;
    }



    public Map(){

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

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }


}
