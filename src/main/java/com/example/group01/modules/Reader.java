package com.example.group01.modules;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Table(name = "reader")
@Getter
@Setter
@NoArgsConstructor
public class Reader {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private long id;
    private String title;
    private String longitude;
    private String latitude;
    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "controller_id",nullable = false)
    private Controller controller;

    public Reader(String title, String longitude, String latitude, Controller controller) {
        this.title = title;
        this.longitude = longitude;
        this.latitude = latitude;
        this.controller = controller;
    }
}
