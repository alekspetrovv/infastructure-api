package com.example.group01.modules;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "zone")
public class Zone implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private long id;
    private String title;
    private String img;


    //TODO
    @ManyToOne
    @JoinColumn(name = "map_id", nullable = false)
    private Map map;


    @OneToMany(
            fetch = FetchType.LAZY,
            mappedBy = "zone",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Controller> controllerList = new ArrayList<>();


    public Zone(String title, String img, Map map) {
        this.title = title;
        this.img = img;
        this.map = map;
    }

}
