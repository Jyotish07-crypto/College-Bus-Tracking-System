package com.Project.CollegeBus.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class StudentBusAssignmentDto {
    private Long assignmentId;
    private Long studentId;
    private Long busId;
    private LocalDate startDate;
    private LocalDate endDate;
    private Boolean isActive;
}
