package com.Project.CollegeBus.repository;

import com.Project.CollegeBus.entity.BusLocation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BusLocationRepository extends JpaRepository<BusLocation, Long> {
    List<BusLocation> findByTripTripIdOrderByRecordedAtAsc(Long tripId);
    Optional<BusLocation> findTopByTripTripIdOrderByRecordedAtDesc(Long tripId);
    Optional<BusLocation> findTopByTripBusBusIdOrderByRecordedAtDesc(Long busId);
}
