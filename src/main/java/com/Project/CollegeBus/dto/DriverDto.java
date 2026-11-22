package com.Project.CollegeBus.dto;

import lombok.Data;

@Data
public class DriverDto {
    private Long driverId;
    private Long userId;
    private String licenseNumber;
    private String phone;
}
