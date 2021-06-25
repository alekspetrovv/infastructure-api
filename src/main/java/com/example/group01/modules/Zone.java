package com.example.group01.modules;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;

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
@DynamicUpdate
@Table(name = "zone")
public class Zone implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private long id;
    private String title;
    private String img;
    private String latLngs;
    private String readers;

    @ManyToOne
    @JoinColumn(name = "map_id", nullable = false)
    private Map map;

    @OneToMany(
            fetch = FetchType.LAZY,
            mappedBy = "zone",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JsonBackReference
    private List<Point> pointsList = new ArrayList<>();


//    @ManyToMany(fetch = FetchType.LAZY)
//    @JoinTable( name = "zones_readers",
//            joinColumns = @JoinColumn(name = "zone_id"),
//            inverseJoinColumns = @JoinColumn(name = "reader_id"))
//    private Set<Reader> readers = new HashSet<>();


    public Zone(String title, String img, Map map) {
        this.title = title;
        this.img = img;
        this.map = map;
    }

    public String getImg() {
        return "/img/zones/" + this.id + "/" + this.img;
    }

}
