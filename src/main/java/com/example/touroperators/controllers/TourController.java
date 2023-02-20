package com.example.touroperators.controllers;

import com.example.touroperators.Services.TourService;
import com.example.touroperators.entities.Tour;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class TourController {

    private final TourService tourService;

    public TourController(TourService tourService) {
        this.tourService = tourService;
    }

    @GetMapping(value = "/tour/{id}")
    public ResponseEntity<Tour> getTourById(@PathVariable long id) throws Exception {
        return tourService.getTourById(id);
    }

    @PostMapping(value = "/tour/add", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> addTour(@RequestBody Tour tour){
        return tourService.addTour(tour);
    }

    @DeleteMapping(value = "/tour/deleted/{id}")
    public ResponseEntity<String> deletedTourById(@PathVariable long id){
        return tourService.deletedTourById(id);
    }

    @PutMapping(value = "/tour/update")
    public void updateTour(@RequestBody Tour tour){
        tourService.updateTour(tour);
    }
}
