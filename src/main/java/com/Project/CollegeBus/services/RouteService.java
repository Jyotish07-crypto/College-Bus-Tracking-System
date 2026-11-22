package com.Project.CollegeBus.services;

import com.Project.CollegeBus.dto.RouteDto;
import com.Project.CollegeBus.entity.Route;
import com.Project.CollegeBus.exception.ResourceNotFoundException;
import com.Project.CollegeBus.repository.RouteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RouteService {
    private final RouteRepository routeRepository;

    public RouteService(RouteRepository routeRepository) { this.routeRepository = routeRepository; }

    public RouteDto create(RouteDto dto) { Route route = new Route(); copy(dto, route); return toDto(routeRepository.save(route)); }
    public List<RouteDto> findAll() { return routeRepository.findAll().stream().map(this::toDto).toList(); }
    public RouteDto findById(Long id) { return toDto(entity(id)); }
    public RouteDto update(Long id, RouteDto dto) { Route route = entity(id); copy(dto, route); return toDto(routeRepository.save(route)); }
    public void delete(Long id) { routeRepository.delete(entity(id)); }

    private Route entity(Long id) { return routeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Route", id)); }
    private void copy(RouteDto dto, Route route) {
        route.setRouteName(dto.getRouteName()); route.setStartPoint(dto.getStartPoint());
        route.setEndPoint(dto.getEndPoint()); route.setIsActive(dto.getIsActive());
    }
    private RouteDto toDto(Route route) {
        RouteDto dto = new RouteDto(); dto.setRouteId(route.getRouteId()); dto.setRouteName(route.getRouteName());
        dto.setStartPoint(route.getStartPoint()); dto.setEndPoint(route.getEndPoint()); dto.setIsActive(route.getIsActive()); return dto;
    }
}
