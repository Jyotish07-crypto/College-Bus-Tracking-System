package com.Project.CollegeBus.services;

import com.Project.CollegeBus.dto.BusLocationDto;
import com.Project.CollegeBus.entity.BusLocation;
import com.Project.CollegeBus.entity.Trip;
import com.Project.CollegeBus.exception.ResourceNotFoundException;
import com.Project.CollegeBus.repository.BusLocationRepository;
import com.Project.CollegeBus.repository.BusRepository;
import com.Project.CollegeBus.repository.TripRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class BusLocationService {
    private final BusLocationRepository locationRepository; private final TripRepository tripRepository; private final BusRepository busRepository;
    public BusLocationService(BusLocationRepository locationRepository, TripRepository tripRepository, BusRepository busRepository) { this.locationRepository = locationRepository; this.tripRepository = tripRepository; this.busRepository = busRepository; }
    public BusLocationDto create(Long tripId, BusLocationDto dto) { BusLocation location = new BusLocation(); location.setTrip(trip(tripId)); location.setLatitude(dto.getLatitude()); location.setLongitude(dto.getLongitude()); location.setSpeed(dto.getSpeed()); location.setRecordedAt(dto.getRecordedAt() == null ? LocalDateTime.now() : dto.getRecordedAt()); return toDto(locationRepository.save(location)); }
    public List<BusLocationDto> history(Long tripId) { trip(tripId); return locationRepository.findByTripTripIdOrderByRecordedAtAsc(tripId).stream().map(this::toDto).toList(); }
    public BusLocationDto latestForTrip(Long tripId) { trip(tripId); return toDto(locationRepository.findTopByTripTripIdOrderByRecordedAtDesc(tripId).orElseThrow(() -> new ResourceNotFoundException("Bus location for trip", tripId))); }
    public BusLocationDto latestForBus(Long busId) { busRepository.findById(busId).orElseThrow(() -> new ResourceNotFoundException("Bus", busId)); return toDto(locationRepository.findTopByTripBusBusIdOrderByRecordedAtDesc(busId).orElseThrow(() -> new ResourceNotFoundException("Bus location for bus", busId))); }
    private Trip trip(Long id) { return tripRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Trip", id)); }
    private BusLocationDto toDto(BusLocation location) { BusLocationDto dto = new BusLocationDto(); dto.setLocationId(location.getLocationId()); dto.setTripId(location.getTrip().getTripId()); dto.setLatitude(location.getLatitude()); dto.setLongitude(location.getLongitude()); dto.setSpeed(location.getSpeed()); dto.setRecordedAt(location.getRecordedAt()); return dto; }
}
