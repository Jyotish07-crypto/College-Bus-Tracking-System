package com.Project.CollegeBus.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(
        name = "route_stops",
        uniqueConstraints = {
                @UniqueConstraint(
                        columnNames =  {"route_id","stop_sequence"}
                )
        }
)
@Getter
@Setter
@NoArgsConstructor
public class RouteStop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long stopId;

    @ManyToOne
    @JoinColumn(name = "route_id", nullable = false)
    private Route route;

    private String stopName;

    private Double latitude;

    private Double longitude;

    private Integer stopSequence;

}
