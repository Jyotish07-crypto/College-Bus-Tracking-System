package com.Project.CollegeBus.entity;

import com.Project.CollegeBus.enums.BusStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "buses")
public class Bus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long busId;

    @ManyToOne
    @JoinColumn(name = "route_id")
    private Route route;

    @Column(nullable = false,unique = true)
    private String busNumber;

    @Column(nullable = false,unique = true)

    private String registrationNumber;

    private Integer capacity;

    @Enumerated(EnumType.STRING)
    private BusStatus status;

    @OneToMany(mappedBy = "bus")
    private List<StudentBusAssignment> studentBusAssignments = new ArrayList<>();

    @OneToMany(mappedBy = "bus")
    private List<Trip> trips = new ArrayList<>();
}

