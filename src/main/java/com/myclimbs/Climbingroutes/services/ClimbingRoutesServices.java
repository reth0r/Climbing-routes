package com.myclimbs.Climbingroutes.services;


import com.myclimbs.Climbingroutes.models.ClimbingRoutes;
import com.myclimbs.Climbingroutes.models.ClimbingRoutesDto;
import com.myclimbs.Climbingroutes.repositories.ClimbingRoutesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service

public class ClimbingRoutesServices {


    private ClimbingRoutesRepo climbingRoutesRepo;
    private RouteMapper routeMapper;

    public ClimbingRoutesServices(ClimbingRoutesRepo climbingRoutesRepo, RouteMapper routeMapper) {
        this.climbingRoutesRepo = climbingRoutesRepo;
        this.routeMapper = routeMapper;
    }

    public ClimbingRoutesDto saveClimbingRoute(ClimbingRoutesDto dto)
    {
        var route = routeMapper.toClimbingRoute(dto);
        var savedRoute =  climbingRoutesRepo.save(route);
        return routeMapper.climbingRouteDto(savedRoute);
    }

    public List<ClimbingRoutesDto> getAll() {
        return climbingRoutesRepo.findAll().stream()
                .map(RouteMapper::climbingRouteDto)
                .collect(Collectors.toList());
    }

    public void addRoute(ClimbingRoutes climbingRoutes) {
        climbingRoutesRepo.save(climbingRoutes);
    }

    public void updateRoute(Long id,ClimbingRoutes climbingRoutes) {
        ClimbingRoutes routeToUpdate = climbingRoutesRepo.findById(id).orElseThrow(()->
            new IllegalStateException(String.format("Traseul cu id-iul %s nu exista",id)));
        // Update the properties of routeToUpdate with the values from climbingRoutes
        routeToUpdate.setRouteName(climbingRoutes.getRouteName());
        routeToUpdate.setRouteGrade(climbingRoutes.getRouteGrade());
        routeToUpdate.setSector(climbingRoutes.getSector());
        routeToUpdate.setProject(climbingRoutes.getProject());

        // Save the updated route
        climbingRoutesRepo.save(routeToUpdate);
    }


    public void deleteRoute(Long id) {
        climbingRoutesRepo.deleteById(id);
    }
}
