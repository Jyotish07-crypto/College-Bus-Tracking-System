package com.Project.CollegeBus.controller;

import com.Project.CollegeBus.dto.RouteDto;
import com.Project.CollegeBus.services.RouteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/routes")
public class RouteController {
    private final RouteService routeService;
    public RouteController(RouteService routeService) { this.routeService = routeService; }
    @PostMapping public ResponseEntity<RouteDto> create(@RequestBody RouteDto dto) { return ResponseEntity.status(HttpStatus.CREATED).body(routeService.create(dto)); }
    @GetMapping public List<RouteDto> findAll() { return routeService.findAll(); }
    @GetMapping("/{id}") public RouteDto findById(@PathVariable Long id) { return routeService.findById(id); }
    @PutMapping("/{id}") public RouteDto update(@PathVariable Long id, @RequestBody RouteDto dto) { return routeService.update(id, dto); }
    @DeleteMapping("/{id}") public ResponseEntity<Void> delete(@PathVariable Long id) { routeService.delete(id); return ResponseEntity.noContent().build(); }
}
