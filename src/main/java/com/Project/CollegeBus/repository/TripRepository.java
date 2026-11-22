package com.Project.CollegeBus.repository;

import com.Project.CollegeBus.entity.Trip;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TripRepository extends JpaRepository<Trip, Long> {
}
