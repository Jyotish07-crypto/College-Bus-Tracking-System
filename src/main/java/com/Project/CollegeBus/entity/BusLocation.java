package com.Project.CollegeBus.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(
        name = "bus_locations",
        indexes = {
                @Index(
                        name = "idx_trip_recorded_at",
                        columnList = "trip_id, recorded_at"
                )
        }
)
@Getter
@Setter
@NoArgsConstructor
public class BusLocation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long locationId;

    @ManyToOne
    @JoinColumn(name="trip_id",nullable = false)
    private Trip trip;

    private Double latitude;

    private Double longitude;


    private Double speed;

    private LocalDateTime recordedAt;


}
