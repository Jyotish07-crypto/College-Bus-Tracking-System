package com.Project.CollegeBus.repository;

import com.Project.CollegeBus.entity.RouteStop;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RouteStopRepository extends JpaRepository<RouteStop, Long> {
    List<RouteStop> findByRouteRouteId(Long routeId);
}
