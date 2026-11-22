package com.Project.CollegeBus.dto;

import lombok.Data;

@Data
public class RouteDto {
    private Long routeId;
    private String routeName;
    private String startPoint;
    private String endPoint;
    private Boolean isActive;
}
