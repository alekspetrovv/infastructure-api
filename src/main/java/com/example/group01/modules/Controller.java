package com.example.group01.modules;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Entity
@Getter
@Setter
@NoArgsConstructor
@DynamicUpdate
@Table(name = "controller")
public class Controller implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private long id;
    private String remarks;
    private String status;
    private LocalDateTime fromTime;
    private LocalDateTime untilTime;
    private Boolean enabled;
    private String longitude;
    private String latitude;
    private long mapId;


//    @OneToMany(
//            mappedBy = "controller",
//            fetch = FetchType.LAZY,
//            cascade = CascadeType.ALL,
//            orphanRemoval = true
//    )
//    @JsonBackReference
//    private List<Reader> readerList = new ArrayList<>();


    public Controller(String remarks, String longitude, String latitude, long mapId) {
        this.remarks = remarks;
        this.longitude = longitude;
        this.latitude = latitude;
        this.mapId = mapId;
    }


}
