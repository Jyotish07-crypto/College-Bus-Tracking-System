package com.Project.CollegeBus.controller;

import com.Project.CollegeBus.dto.BusDto;
import com.Project.CollegeBus.services.BusService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/buses")
public class BusController {
    private final BusService busService;
    public BusController(BusService busService) { this.busService = busService; }
    @PostMapping public ResponseEntity<BusDto> create(@RequestBody BusDto dto) { return ResponseEntity.status(HttpStatus.CREATED).body(busService.create(dto)); }
    @GetMapping public List<BusDto> findAll() { return busService.findAll(); }
    @GetMapping("/{id}") public BusDto findById(@PathVariable Long id) { return busService.findById(id); }
    @PutMapping("/{id}") public BusDto update(@PathVariable Long id, @RequestBody BusDto dto) { return busService.update(id, dto); }
    @DeleteMapping("/{id}") public ResponseEntity<Void> delete(@PathVariable Long id) { busService.delete(id); return ResponseEntity.noContent().build(); }
}
