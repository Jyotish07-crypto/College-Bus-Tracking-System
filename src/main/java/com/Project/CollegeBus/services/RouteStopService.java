package com.Project.CollegeBus.services;

import com.Project.CollegeBus.dto.RouteStopDto;
import com.Project.CollegeBus.entity.Route;
import com.Project.CollegeBus.entity.RouteStop;
import com.Project.CollegeBus.exception.ResourceNotFoundException;
import com.Project.CollegeBus.repository.RouteRepository;
import com.Project.CollegeBus.repository.RouteStopRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RouteStopService {
    private final RouteStopRepository stopRepository;
    private final RouteRepository routeRepository;
    public RouteStopService(RouteStopRepository stopRepository, RouteRepository routeRepository) { this.stopRepository = stopRepository; this.routeRepository = routeRepository; }
    public RouteStopDto create(Long routeId, RouteStopDto dto) { RouteStop stop = new RouteStop(); copy(dto, stop, routeId); return toDto(stopRepository.save(stop)); }
    public List<RouteStopDto> findByRoute(Long routeId) { route(routeId); return stopRepository.findByRouteRouteId(routeId).stream().map(this::toDto).toList(); }
    public RouteStopDto update(Long id, RouteStopDto dto) { RouteStop stop = entity(id); copy(dto, stop, dto.getRouteId() == null ? stop.getRoute().getRouteId() : dto.getRouteId()); return toDto(stopRepository.save(stop)); }
    public void delete(Long id) { stopRepository.delete(entity(id)); }
    private RouteStop entity(Long id) { return stopRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Route stop", id)); }
    private Route route(Long id) { return routeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Route", id)); }
    private void copy(RouteStopDto dto, RouteStop stop, Long routeId) { stop.setRoute(route(routeId)); stop.setStopName(dto.getStopName()); stop.setLatitude(dto.getLatitude()); stop.setLongitude(dto.getLongitude()); stop.setStopSequence(dto.getStopSequence()); }
    private RouteStopDto toDto(RouteStop stop) { RouteStopDto dto = new RouteStopDto(); dto.setStopId(stop.getStopId()); dto.setRouteId(stop.getRoute().getRouteId()); dto.setStopName(stop.getStopName()); dto.setLatitude(stop.getLatitude()); dto.setLongitude(stop.getLongitude()); dto.setStopSequence(stop.getStopSequence()); return dto; }
}
