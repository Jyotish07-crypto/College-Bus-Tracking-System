package com.Project.CollegeBus.repository;

import com.Project.CollegeBus.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
