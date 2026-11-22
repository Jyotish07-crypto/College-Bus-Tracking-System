package com.Project.CollegeBus.controller;

import com.Project.CollegeBus.dto.DriverDto;
import com.Project.CollegeBus.services.DriverService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/drivers")
public class DriverController {
    private final DriverService driverService;

    public DriverController(DriverService driverService) {
        this.driverService = driverService;
    }

    @PostMapping
    public ResponseEntity<DriverDto> create(@RequestBody DriverDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(driverService.create(dto));
    }

    @GetMapping
    public List<DriverDto> findAll() {
        return driverService.findAll();
    }

    @GetMapping("/{id}")
    public DriverDto findById(@PathVariable Long id) {
        return driverService.findById(id);
    }

    @PutMapping("/{id}")
    public DriverDto update(@PathVariable Long id, @RequestBody DriverDto dto) {
        return driverService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        driverService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
