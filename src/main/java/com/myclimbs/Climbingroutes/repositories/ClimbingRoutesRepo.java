package com.myclimbs.Climbingroutes.repositories;

import com.myclimbs.Climbingroutes.models.ClimbingRoutes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ClimbingRoutesRepo extends JpaRepository<ClimbingRoutes, Long> {
}
