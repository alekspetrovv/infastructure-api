package com.example.group01.modules;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@DynamicUpdate
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
            mappedBy = "map",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JsonManagedReference
    private List<Zone> zones = new ArrayList<>();

    public List<Zone> getZones()  {
            return this.zones;
    }


    public Map(String title, String img, String latitude, String longitude) {
        this.title = title;
        this.img = img;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getImg() {
       return "/img/maps/" + this.id + "/" + this.img;
    }

    public void attachZone(Zone zone) {
        this.zones.add(zone);
    }
}
