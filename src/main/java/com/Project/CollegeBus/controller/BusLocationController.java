package com.Project.CollegeBus.controller;

import com.Project.CollegeBus.dto.BusLocationDto;
import com.Project.CollegeBus.services.BusLocationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BusLocationController {
    private final BusLocationService busLocationService;
    public BusLocationController(BusLocationService busLocationService) { this.busLocationService = busLocationService; }
    @PostMapping("/api/trips/{tripId}/locations") public ResponseEntity<BusLocationDto> create(@PathVariable Long tripId, @RequestBody BusLocationDto dto) { return ResponseEntity.status(HttpStatus.CREATED).body(busLocationService.create(tripId, dto)); }
    @GetMapping("/api/trips/{tripId}/locations") public List<BusLocationDto> history(@PathVariable Long tripId) { return busLocationService.history(tripId); }
    @GetMapping("/api/trips/{tripId}/locations/latest") public BusLocationDto latestForTrip(@PathVariable Long tripId) { return busLocationService.latestForTrip(tripId); }
    @GetMapping("/api/tracking/buses/{busId}") public BusLocationDto latestForBus(@PathVariable Long busId) { return busLocationService.latestForBus(busId); }
}
