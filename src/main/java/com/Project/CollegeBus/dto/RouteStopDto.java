package com.Project.CollegeBus.dto;

import lombok.Data;

@Data
public class RouteStopDto {
    private Long stopId;
    private Long routeId;
    private String stopName;
    private Double latitude;
    private Double longitude;
    private Integer stopSequence;
}
