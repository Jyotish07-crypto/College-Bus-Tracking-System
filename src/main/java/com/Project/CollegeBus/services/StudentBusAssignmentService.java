package com.Project.CollegeBus.services;

import com.Project.CollegeBus.dto.StudentBusAssignmentDto;
import com.Project.CollegeBus.entity.Bus;
import com.Project.CollegeBus.entity.Student;
import com.Project.CollegeBus.entity.StudentBusAssignment;
import com.Project.CollegeBus.exception.ResourceNotFoundException;
import com.Project.CollegeBus.repository.BusRepository;
import com.Project.CollegeBus.repository.StudentBusAssignmentRepository;
import com.Project.CollegeBus.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class StudentBusAssignmentService {
    private final StudentBusAssignmentRepository assignmentRepository; private final StudentRepository studentRepository; private final BusRepository busRepository;
    public StudentBusAssignmentService(StudentBusAssignmentRepository assignmentRepository, StudentRepository studentRepository, BusRepository busRepository) { this.assignmentRepository = assignmentRepository; this.studentRepository = studentRepository; this.busRepository = busRepository; }
    public StudentBusAssignmentDto create(StudentBusAssignmentDto dto) { StudentBusAssignment assignment = new StudentBusAssignment(); copy(dto, assignment); return toDto(assignmentRepository.save(assignment)); }
    public List<StudentBusAssignmentDto> findAll() { return assignmentRepository.findAll().stream().map(this::toDto).toList(); }
    public StudentBusAssignmentDto findById(Long id) { return toDto(entity(id)); }
    public StudentBusAssignmentDto update(Long id, StudentBusAssignmentDto dto) { StudentBusAssignment assignment = entity(id); copy(dto, assignment); return toDto(assignmentRepository.save(assignment)); }
    public StudentBusAssignmentDto end(Long id, StudentBusAssignmentDto dto) { StudentBusAssignment assignment = entity(id); assignment.setEndDate(dto != null && dto.getEndDate() != null ? dto.getEndDate() : LocalDate.now()); assignment.setIsActive(false); return toDto(assignmentRepository.save(assignment)); }
    private StudentBusAssignment entity(Long id) { return assignmentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Student bus assignment", id)); }
    private Student student(Long id) { return studentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Student", id)); }
    private Bus bus(Long id) { return busRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Bus", id)); }
    private void copy(StudentBusAssignmentDto dto, StudentBusAssignment assignment) { assignment.setStudent(student(dto.getStudentId())); assignment.setBus(bus(dto.getBusId())); assignment.setStartDate(dto.getStartDate()); assignment.setEndDate(dto.getEndDate()); assignment.setIsActive(dto.getIsActive()); }
    private StudentBusAssignmentDto toDto(StudentBusAssignment assignment) { StudentBusAssignmentDto dto = new StudentBusAssignmentDto(); dto.setAssignmentId(assignment.getAssignmentId()); dto.setStudentId(assignment.getStudent().getStudentId()); dto.setBusId(assignment.getBus().getBusId()); dto.setStartDate(assignment.getStartDate()); dto.setEndDate(assignment.getEndDate()); dto.setIsActive(assignment.getIsActive()); return dto; }
}
