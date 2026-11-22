package com.Project.CollegeBus.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TripDto {
    private Long tripId;
    private Long busId;
    private Long driverId;
    private Long routeId;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String tripStatus;
}
