package com.Project.CollegeBus.controller;

import com.Project.CollegeBus.dto.RouteStopDto;
import com.Project.CollegeBus.services.RouteStopService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RouteStopController {
    private final RouteStopService routeStopService;
    public RouteStopController(RouteStopService routeStopService) { this.routeStopService = routeStopService; }
    @PostMapping("/api/routes/{routeId}/stops") public ResponseEntity<RouteStopDto> create(@PathVariable Long routeId, @RequestBody RouteStopDto dto) { return ResponseEntity.status(HttpStatus.CREATED).body(routeStopService.create(routeId, dto)); }
    @GetMapping("/api/routes/{routeId}/stops") public List<RouteStopDto> findByRoute(@PathVariable Long routeId) { return routeStopService.findByRoute(routeId); }
    @PutMapping("/api/stops/{stopId}") public RouteStopDto update(@PathVariable Long stopId, @RequestBody RouteStopDto dto) { return routeStopService.update(stopId, dto); }
    @DeleteMapping("/api/stops/{stopId}") public ResponseEntity<Void> delete(@PathVariable Long stopId) { routeStopService.delete(stopId); return ResponseEntity.noContent().build(); }
}
