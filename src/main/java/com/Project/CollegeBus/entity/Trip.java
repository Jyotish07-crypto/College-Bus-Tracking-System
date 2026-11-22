package com.Project.CollegeBus.entity;

import com.Project.CollegeBus.enums.TripStatus;
import jakarta.persistence.*;
import lombok.Generated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "trips")
public class Trip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tripId;

    @ManyToOne
    @JoinColumn(name = "driver_id", nullable = false)
    private Driver driver;

    @ManyToOne
    @JoinColumn(name = "bus_id",nullable = false)
    private Bus bus;

    @ManyToOne
    @JoinColumn(name = "route_id",nullable = false)
    private Route route;

    private LocalDateTime startTime;

    private  LocalDateTime endTime;

    @Enumerated(EnumType.STRING)
    private TripStatus tripStatus;

    @OneToMany(mappedBy = "trip")
    private List<BusLocation> locations = new ArrayList<>();

}
