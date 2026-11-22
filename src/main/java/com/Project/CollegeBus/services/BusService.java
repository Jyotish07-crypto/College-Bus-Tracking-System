package com.Project.CollegeBus.services;

import com.Project.CollegeBus.dto.BusDto;
import com.Project.CollegeBus.entity.Bus;
import com.Project.CollegeBus.entity.Route;
import com.Project.CollegeBus.enums.BusStatus;
import com.Project.CollegeBus.exception.ResourceNotFoundException;
import com.Project.CollegeBus.repository.BusRepository;
import com.Project.CollegeBus.repository.RouteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusService {
    private final BusRepository busRepository; private final RouteRepository routeRepository;
    public BusService(BusRepository busRepository, RouteRepository routeRepository) { this.busRepository = busRepository; this.routeRepository = routeRepository; }
    public BusDto create(BusDto dto) { Bus bus = new Bus(); copy(dto, bus); return toDto(busRepository.save(bus)); }
    public List<BusDto> findAll() { return busRepository.findAll().stream().map(this::toDto).toList(); }
    public BusDto findById(Long id) { return toDto(entity(id)); }
    public BusDto update(Long id, BusDto dto) { Bus bus = entity(id); copy(dto, bus); return toDto(busRepository.save(bus)); }
    public void delete(Long id) { busRepository.delete(entity(id)); }
    private Bus entity(Long id) { return busRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Bus", id)); }
    private Route route(Long id) { return routeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Route", id)); }
    private void copy(BusDto dto, Bus bus) { bus.setRoute(route(dto.getRouteId())); bus.setBusNumber(dto.getBusNumber()); bus.setRegistrationNumber(dto.getRegistrationNumber()); bus.setCapacity(dto.getCapacity()); bus.setStatus(dto.getStatus() == null ? null : BusStatus.valueOf(dto.getStatus())); }
    private BusDto toDto(Bus bus) { BusDto dto = new BusDto(); dto.setBusId(bus.getBusId()); dto.setRouteId(bus.getRoute().getRouteId()); dto.setBusNumber(bus.getBusNumber()); dto.setRegistrationNumber(bus.getRegistrationNumber()); dto.setCapacity(bus.getCapacity()); dto.setStatus(bus.getStatus() == null ? null : bus.getStatus().name()); return dto; }
}
