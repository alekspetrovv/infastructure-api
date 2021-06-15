package com.example.group01.modules;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
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

    @ManyToOne
    @JoinColumn(name = "map_id", nullable = false)
    @JsonBackReference
    private Map map;

    @OneToMany
    @JoinColumn(name = "zone_id") // we need to duplicate the physical information
    @JsonManagedReference
    private Set<Point> pointsList;


    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable( name = "zones_readers",
            joinColumns = @JoinColumn(name = "zone_id"),
            inverseJoinColumns = @JoinColumn(name = "reader_id"))
    private Set<Reader> readers = new HashSet<>();


    public Zone(String title, String img, Map map) {
        this.title = title;
        this.img = img;
        this.map = map;
    }

    public String getImg() {
        return "/img/zones/" + this.id + "/" + this.img;
    }

}
