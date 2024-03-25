package com.myclimbs.Climbingroutes.controllers;

import com.myclimbs.Climbingroutes.models.ClimbingRoutes;
import com.myclimbs.Climbingroutes.services.ClimbingRoutesServices;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class HomeController {

    private ClimbingRoutesServices climbingRoutesServices;

    public HomeController(ClimbingRoutesServices climbingRoutesServices) {
        this.climbingRoutesServices = climbingRoutesServices;
    }

//    @GetMapping("/")
//
//    public ModelAndView index() {
//        ModelAndView modelAndView = new ModelAndView("index");
//        modelAndView.addObject("climbingRoutes", climbingRoutesServices.getAll());
//        return modelAndView;
//    }



}
