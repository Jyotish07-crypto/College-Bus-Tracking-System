package com.Project.CollegeBus.services;

import com.Project.CollegeBus.dto.DriverDto;
import com.Project.CollegeBus.entity.Driver;
import com.Project.CollegeBus.entity.User;
import com.Project.CollegeBus.exception.ResourceNotFoundException;
import com.Project.CollegeBus.repository.DriverRepository;
import com.Project.CollegeBus.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DriverService {
    private final DriverRepository driverRepository;
    private final UserRepository userRepository;

    public DriverService(DriverRepository driverRepository, UserRepository userRepository) {
        this.driverRepository = driverRepository;
        this.userRepository = userRepository;
    }

    public DriverDto create(DriverDto dto) {
        Driver driver = new Driver();
        copy(dto, driver);
        return toDto(driverRepository.save(driver));
    }

    public List<DriverDto> findAll() {
        return driverRepository.findAll().stream().map(this::toDto).toList();
    }

    public DriverDto findById(Long id) {
        return toDto(findEntity(id));
    }

    public DriverDto update(Long id, DriverDto dto) {
        Driver driver = findEntity(id);
        copy(dto, driver);
        return toDto(driverRepository.save(driver));
    }

    public void delete(Long id) {
        driverRepository.delete(findEntity(id));
    }

    private Driver findEntity(Long id) {
        return driverRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Driver", id));
    }

    private void copy(DriverDto dto, Driver driver) {
        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new ResourceNotFoundException("User", dto.getUserId()));
        driver.setUser(user);
        driver.setLicenseNumber(dto.getLicenseNumber());
        driver.setPhone(dto.getPhone());
    }

    private DriverDto toDto(Driver driver) {
        DriverDto dto = new DriverDto();
        dto.setDriverId(driver.getDriverId());
        dto.setUserId(driver.getUser().getId());
        dto.setLicenseNumber(driver.getLicenseNumber());
        dto.setPhone(driver.getPhone());
        return dto;
    }
}
