package com.example.group01.modules;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "map")
public class Map implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private long id;
    private String title;
    private String latitude;
    private String longitude;
    private String img;
    @OneToMany(
            fetch = FetchType.EAGER,
            mappedBy = "map",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    //TODO
    private Set<Zone> zones = new HashSet<>();

    public Map(String title, String img, String latitude, String longitude) {
        this.title = title;
        this.img = img;
        this.latitude = latitude;
        this.longitude = longitude;
    }

}
