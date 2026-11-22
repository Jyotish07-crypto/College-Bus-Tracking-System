package com.Project.CollegeBus.dto;

import lombok.Data;

@Data
public class BusDto {
    private Long busId;
    private Long routeId;
    private String busNumber;
    private String registrationNumber;
    private Integer capacity;
    private String status;
}
