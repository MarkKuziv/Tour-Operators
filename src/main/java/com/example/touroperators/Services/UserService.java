package com.example.touroperators.Services;

import com.example.touroperators.Exceptiond.TourNotFoundException;
import com.example.touroperators.Exceptiond.UserNotFoundException;
import com.example.touroperators.entities.Company;
import com.example.touroperators.entities.Tour;
import com.example.touroperators.entities.UserEntities;
import com.example.touroperators.repositories.CompanyRepository;
import com.example.touroperators.repositories.TourRepository;
import com.example.touroperators.repositories.UserRepository;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);

    private final CompanyRepository companyRepository;
    private final TourRepository tourRepository;
    private final UserRepository userRepository;

    public UserService(CompanyRepository companyRepository, TourRepository tourRepository, UserRepository userRepository) {
        this.companyRepository = companyRepository;
        this.tourRepository = tourRepository;
        this.userRepository = userRepository;
    }

    public List<UserEntities> getAllUsers(){
        return userRepository.findAll();
    }

    public ResponseEntity<UserEntities> getUserById(Long id) throws Exception {
        UserEntities user = userRepository.findUserById(id);
        if (user == null){
            LOGGER.info("User with " + id + " not found");
            throw new UserNotFoundException(String.format("User with %d not found", id));
        }
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    public ResponseEntity<String> addUser(UserEntities user){
        UserEntities userMaybe = userRepository.findUserByIdentificationCode(user.getIdentificationCode());
        Company company = companyRepository.findCompanyByCompanyName(user.getCompany().getCompanyName());
        Tour tour = tourRepository.findTourByName(user.getTour().getName());

        if (userMaybe != null) {
            LOGGER.info("User found " + userMaybe);
            return new ResponseEntity<>("User already exists", HttpStatus.OK);
        }

        if (tour != null){
            LOGGER.info("Tour found");
            return new ResponseEntity<>("Tour found", HttpStatus.OK);
        }

        checkCompany(user, company);
        LOGGER.info("Added user");
        return new ResponseEntity<>("Added", HttpStatus.OK);
    }

    private void checkCompany(UserEntities user, Company company) {
        if (company == null){
            userRepository.save(user);
        }else{
            user.setCompany(company);
            userRepository.save(user);
        }
    }

    public ResponseEntity<String> deletedUserById(Long id){
        userRepository.deleteById(id);
        LOGGER.info("Deleted user");
        return new ResponseEntity<>("Deleted user", HttpStatus.OK);
    }

    public void updateUser(UserEntities newUser) {
        UserEntities user = userRepository.findUserById(newUser.getId());
        update(user, newUser);
        LOGGER.info("Updated with: " + newUser.getId());
        userRepository.save(user);

    }

    public void update(UserEntities user, UserEntities newUser){
        user.setUserName(newUser.getUserName());
        user.setLastName(newUser.getLastName());
        user.setBirthDay(newUser.getBirthDay());
        user.setIdentificationCode(newUser.getIdentificationCode());
        user.setRole(newUser.getRole());
    }
}
