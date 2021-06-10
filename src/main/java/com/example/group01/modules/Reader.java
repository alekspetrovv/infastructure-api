package com.example.group01.modules;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "reader")
@Getter
@Setter
@NoArgsConstructor
@DynamicUpdate
public class Reader {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private long id;
    private String remarks;
    private Date fromTime;
    private Date untilTime;
    private Boolean enabled;
    private String longitude;
    private String status;
    private String latitude;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "controller_id", nullable = false)
    @JsonBackReference
    private Controller controller;


    public Reader(String remarks, Date fromTime, Date untilTime, Boolean enabled, String status, String longitude, String latitude, Controller controller) {
        this.remarks = remarks;
        this.fromTime = fromTime;
        this.untilTime = untilTime;
        this.enabled = enabled;
        this.status = status;
        this.longitude = longitude;
        this.latitude = latitude;
        this.controller = controller;
    }
}
