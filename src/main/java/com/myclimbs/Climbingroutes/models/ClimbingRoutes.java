package com.myclimbs.Climbingroutes.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name= "climbing-routes")

public class ClimbingRoutes implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty(message = "You must provide a Route Name!")
    private String routeName;
    @NotEmpty(message = "You must provide a Route Grade!")
    private String routeGrade;
    @NotEmpty(message = "You must provide a Sector Name!")
    private String sector;
    private String project;



}
