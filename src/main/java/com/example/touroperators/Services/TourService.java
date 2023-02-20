package com.example.touroperators.Services;

import com.example.touroperators.Exceptiond.TourNotFoundException;
import com.example.touroperators.entities.Tour;
import com.example.touroperators.entities.UserEntities;
import com.example.touroperators.repositories.TourRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class TourService {

    private static final Logger LOGGER = LoggerFactory.getLogger(TourService.class);


    private final TourRepository tourRepository;

    public TourService(TourRepository tourRepository) {
        this.tourRepository = tourRepository;
    }

    public ResponseEntity<Tour> getTourById(Long id) throws Exception {
        Tour tour = tourRepository.findTourById(id);
        if (tour == null){
            LOGGER.info("Tour with " + id + " not found");
            throw new TourNotFoundException(String.format("Tour with %d not found", id)); // якщо не знайшов кидай помилку
        }
        return new ResponseEntity<>(tour, HttpStatus.OK );
    }

    public ResponseEntity<String> deletedTourById(Long id){
        tourRepository.deleteById(id);
        LOGGER.info("Deleted tour");
        return new ResponseEntity<>("Deleted tour", HttpStatus.OK);
    }

    public void updateTour(Tour newTour) {
        Tour tour = tourRepository.findTourById(newTour.getId());
        update(tour, newTour);
        LOGGER.info("Updated with: " + newTour.getId());
        tourRepository.save(tour);

    }

    public void update(Tour tour, Tour newTour){
        tour.setName(newTour.getName());
        tour.setTourType(newTour.getTourType());
    }

    public ResponseEntity<String> addTour(Tour tour){
        tourRepository.save(tour);
        return new ResponseEntity<>("Added", HttpStatus.OK);
    }

}
