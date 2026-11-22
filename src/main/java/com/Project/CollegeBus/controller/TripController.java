package com.Project.CollegeBus.controller;

import com.Project.CollegeBus.dto.TripDto;
import com.Project.CollegeBus.services.TripService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/trips")
public class TripController {
    private final TripService tripService;
    public TripController(TripService tripService) { this.tripService = tripService; }
    @PostMapping public ResponseEntity<TripDto> create(@RequestBody TripDto dto) { return ResponseEntity.status(HttpStatus.CREATED).body(tripService.create(dto)); }
    @GetMapping public List<TripDto> findAll() { return tripService.findAll(); }
    @GetMapping("/{id}") public TripDto findById(@PathVariable Long id) { return tripService.findById(id); }
    @PatchMapping("/{id}/start") public TripDto start(@PathVariable Long id) { return tripService.start(id); }
    @PatchMapping("/{id}/complete") public TripDto complete(@PathVariable Long id) { return tripService.complete(id); }
    @PatchMapping("/{id}/cancel") public TripDto cancel(@PathVariable Long id) { return tripService.cancel(id); }
}
