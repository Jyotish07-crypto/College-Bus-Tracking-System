package com.Project.CollegeBus.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "routes")
@NoArgsConstructor
public class Route {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long routeId;

    private String routeName;

    private String startPoint;

    private String endPoint;

    private Boolean isActive;

    @OneToMany(mappedBy = "route")
    private List<RouteStop> stops  = new ArrayList<>();

    @OneToMany(mappedBy = "route")
    private List<Bus> buses = new ArrayList<>();

    @OneToMany(mappedBy = "route")
    private List<Trip> trips = new ArrayList<>();
}
