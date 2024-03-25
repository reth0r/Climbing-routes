package com.myclimbs.Climbingroutes.controllers;


import com.myclimbs.Climbingroutes.models.ClimbingRoutes;
import com.myclimbs.Climbingroutes.models.ClimbingRoutesDto;
import com.myclimbs.Climbingroutes.services.ClimbingRoutesServices;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;


import java.util.HashMap;
import java.util.List;

@RestController
public class ClimbingRoutesController {



    private ClimbingRoutesServices climbingRoutesServices;

    public ClimbingRoutesController(ClimbingRoutesServices climbingRoutesServices) {
        this.climbingRoutesServices = climbingRoutesServices;
    }

    @GetMapping("/routes")
    public List<ClimbingRoutesDto> getRoutes() {
       return climbingRoutesServices.getAll();
    }


    @PostMapping("/routes")
    public void addRoute(@Valid @RequestBody ClimbingRoutes climbingRoutes) {
        climbingRoutesServices.addRoute(climbingRoutes);
    }


    @PutMapping(path = "/routes/{id}")
    public void updateRoute(@PathVariable Long id, @RequestBody ClimbingRoutes climbingRoutes) {
        climbingRoutesServices.updateRoute(id,climbingRoutes);
    }


    @DeleteMapping(path = "/routes/{id}")
    public ResponseEntity<String> deleteRoute(@PathVariable Long id) {
        climbingRoutesServices.deleteRoute(id);
        return ResponseEntity.ok().body("Route deleted successfully");
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleMANVE(MethodArgumentNotValidException exp) {
        var errors = new HashMap<String, String>();
        exp.getBindingResult().getAllErrors().forEach(error->{
            var fieldName = ((FieldError) error).getField();
            var errorMessage = error.getDefaultMessage();
            errors.put(fieldName,errorMessage);
        });
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
}
