package com.Project.CollegeBus.dto;

import lombok.Data;

@Data
public class StudentDto {
    private Long studentId;
    private Long userId;
    private String rollNumber;
    private String department;
    private String semester;
    private String phone;
}
