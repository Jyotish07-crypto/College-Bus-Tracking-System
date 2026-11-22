package com.Project.CollegeBus.controller;

import com.Project.CollegeBus.dto.StudentBusAssignmentDto;
import com.Project.CollegeBus.services.StudentBusAssignmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/assignments")
public class StudentBusAssignmentController {
    private final StudentBusAssignmentService assignmentService;
    public StudentBusAssignmentController(StudentBusAssignmentService assignmentService) { this.assignmentService = assignmentService; }
    @PostMapping public ResponseEntity<StudentBusAssignmentDto> create(@RequestBody StudentBusAssignmentDto dto) { return ResponseEntity.status(HttpStatus.CREATED).body(assignmentService.create(dto)); }
    @GetMapping public List<StudentBusAssignmentDto> findAll() { return assignmentService.findAll(); }
    @GetMapping("/{id}") public StudentBusAssignmentDto findById(@PathVariable Long id) { return assignmentService.findById(id); }
    @PutMapping("/{id}") public StudentBusAssignmentDto update(@PathVariable Long id, @RequestBody StudentBusAssignmentDto dto) { return assignmentService.update(id, dto); }
    @PatchMapping("/{id}/end") public StudentBusAssignmentDto end(@PathVariable Long id, @RequestBody(required = false) StudentBusAssignmentDto dto) { return assignmentService.end(id, dto); }
}
