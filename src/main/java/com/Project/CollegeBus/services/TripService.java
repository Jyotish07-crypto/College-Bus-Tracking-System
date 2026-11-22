package com.Project.CollegeBus.services;

import com.Project.CollegeBus.dto.TripDto;
import com.Project.CollegeBus.entity.Bus;
import com.Project.CollegeBus.entity.Driver;
import com.Project.CollegeBus.entity.Route;
import com.Project.CollegeBus.entity.Trip;
import com.Project.CollegeBus.enums.TripStatus;
import com.Project.CollegeBus.exception.ResourceNotFoundException;
import com.Project.CollegeBus.repository.BusRepository;
import com.Project.CollegeBus.repository.DriverRepository;
import com.Project.CollegeBus.repository.RouteRepository;
import com.Project.CollegeBus.repository.TripRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TripService {
    private final TripRepository tripRepository; private final BusRepository busRepository; private final DriverRepository driverRepository; private final RouteRepository routeRepository;
    public TripService(TripRepository tripRepository, BusRepository busRepository, DriverRepository driverRepository, RouteRepository routeRepository) { this.tripRepository = tripRepository; this.busRepository = busRepository; this.driverRepository = driverRepository; this.routeRepository = routeRepository; }
    public TripDto create(TripDto dto) { Trip trip = new Trip(); copy(dto, trip); if (trip.getTripStatus() == null) trip.setTripStatus(TripStatus.SCHEDULED); return toDto(tripRepository.save(trip)); }
    public List<TripDto> findAll() { return tripRepository.findAll().stream().map(this::toDto).toList(); }
    public TripDto findById(Long id) { return toDto(entity(id)); }
    public TripDto start(Long id) { Trip trip = entity(id); trip.setTripStatus(TripStatus.STARTED); trip.setStartTime(LocalDateTime.now()); return toDto(tripRepository.save(trip)); }
    public TripDto complete(Long id) { Trip trip = entity(id); trip.setTripStatus(TripStatus.COMPLETED); trip.setEndTime(LocalDateTime.now()); return toDto(tripRepository.save(trip)); }
    public TripDto cancel(Long id) { Trip trip = entity(id); trip.setTripStatus(TripStatus.CANCELLED); return toDto(tripRepository.save(trip)); }
    private Trip entity(Long id) { return tripRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Trip", id)); }
    private Bus bus(Long id) { return busRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Bus", id)); }
    private Driver driver(Long id) { return driverRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Driver", id)); }
    private Route route(Long id) { return routeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Route", id)); }
    private void copy(TripDto dto, Trip trip) { trip.setBus(bus(dto.getBusId())); trip.setDriver(driver(dto.getDriverId())); trip.setRoute(route(dto.getRouteId())); trip.setStartTime(dto.getStartTime()); trip.setEndTime(dto.getEndTime()); trip.setTripStatus(dto.getTripStatus() == null ? null : TripStatus.valueOf(dto.getTripStatus())); }
    private TripDto toDto(Trip trip) { TripDto dto = new TripDto(); dto.setTripId(trip.getTripId()); dto.setBusId(trip.getBus().getBusId()); dto.setDriverId(trip.getDriver().getDriverId()); dto.setRouteId(trip.getRoute().getRouteId()); dto.setStartTime(trip.getStartTime()); dto.setEndTime(trip.getEndTime()); dto.setTripStatus(trip.getTripStatus().name()); return dto; }
}
