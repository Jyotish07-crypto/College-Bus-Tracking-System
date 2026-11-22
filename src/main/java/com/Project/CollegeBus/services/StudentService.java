package com.Project.CollegeBus.services;

import com.Project.CollegeBus.dto.StudentDto;
import com.Project.CollegeBus.entity.Student;
import com.Project.CollegeBus.entity.User;
import com.Project.CollegeBus.exception.ResourceNotFoundException;
import com.Project.CollegeBus.repository.StudentRepository;
import com.Project.CollegeBus.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private final StudentRepository studentRepository;
    private final UserRepository userRepository;

    public StudentService(StudentRepository studentRepository, UserRepository userRepository) {
        this.studentRepository = studentRepository;
        this.userRepository = userRepository;
    }

    public StudentDto create(StudentDto dto) {
        Student student = new Student();
        copy(dto, student);
        return toDto(studentRepository.save(student));
    }

    public List<StudentDto> findAll() {
        return studentRepository.findAll().stream().map(this::toDto).toList();
    }

    public StudentDto findById(Long id) {
        return toDto(findEntity(id));
    }

    public StudentDto update(Long id, StudentDto dto) {
        Student student = findEntity(id);
        copy(dto, student);
        return toDto(studentRepository.save(student));
    }

    public void delete(Long id) {
        studentRepository.delete(findEntity(id));
    }

    private Student findEntity(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student", id));
    }

    private void copy(StudentDto dto, Student student) {
        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new ResourceNotFoundException("User", dto.getUserId()));
        student.setUser(user);
        student.setRollNumber(dto.getRollNumber());
        student.setDepartment(dto.getDepartment());
        student.setSemester(dto.getSemester());
        student.setPhone(dto.getPhone());
    }

    private StudentDto toDto(Student student) {
        StudentDto dto = new StudentDto();
        dto.setStudentId(student.getStudentId());
        dto.setUserId(student.getUser().getId());
        dto.setRollNumber(student.getRollNumber());
        dto.setDepartment(student.getDepartment());
        dto.setSemester(student.getSemester());
        dto.setPhone(student.getPhone());
        return dto;
    }
}
