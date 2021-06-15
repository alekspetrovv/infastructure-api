package com.example.group01.modules;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@DynamicUpdate
@Table(name = "point")
public class Point implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private long id;
    private String longitude;
    private String latitude;


    @ManyToOne
    @JoinColumn(name = "zone_id", nullable = false)
    @JsonBackReference
    private Zone zone;


    public Point(String longitude, String latitude, Zone zone) {
        this.longitude = longitude;
        this.latitude = latitude;
        this.zone = zone;
    }


}
