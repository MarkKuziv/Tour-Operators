package com.example.touroperators.repositories;

import com.example.touroperators.entities.UserEntities;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntities, Long> {
    UserEntities findUserById(Long id);
    UserEntities findUserByIdentificationCode(long identificationCode);
}
