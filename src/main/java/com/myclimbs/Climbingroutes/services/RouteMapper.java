package com.myclimbs.Climbingroutes.services;

import com.myclimbs.Climbingroutes.models.ClimbingRoutes;
import com.myclimbs.Climbingroutes.models.ClimbingRoutesDto;
import org.springframework.stereotype.Service;

@Service
public class RouteMapper {

    public ClimbingRoutes toClimbingRoute(ClimbingRoutesDto dto) {

        if(dto == null) {
            throw new  NullPointerException("Should not be null");
        }

        var route = new ClimbingRoutes();
        route.setRouteName(dto.routeName());
        route.setRouteGrade(dto.routeGrade());
        route.setSector(dto.sector());
        route.setProject(dto.project());
        return route;
    }

    public static ClimbingRoutesDto climbingRouteDto(ClimbingRoutes climbingRoutes) {
        return new ClimbingRoutesDto(climbingRoutes.getRouteName(),climbingRoutes.getRouteGrade(),
                climbingRoutes.getSector(),climbingRoutes.getProject());
    }
}
