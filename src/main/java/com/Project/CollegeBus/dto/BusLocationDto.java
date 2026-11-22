package com.Project.CollegeBus.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BusLocationDto {
    private Long locationId;
    private Long tripId;
    private Double latitude;
    private Double longitude;
    private Double speed;
    private LocalDateTime recordedAt;
}
