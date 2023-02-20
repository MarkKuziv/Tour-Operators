package com.example.touroperators.repositories;

import com.example.touroperators.entities.Tour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TourRepository extends JpaRepository<Tour, Long> {
    Tour findTourById(Long id);
    Tour findTourByName(String name);

}
