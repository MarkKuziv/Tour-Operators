package com.example.touroperators.Services;

import com.example.touroperators.Exceptiond.CompanyNotFoundException;
import com.example.touroperators.Exceptiond.TourNotFoundException;
import com.example.touroperators.entities.Company;
import com.example.touroperators.entities.Tour;
import com.example.touroperators.repositories.CompanyRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CompanyService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CompanyService.class);

    private final CompanyRepository companyRepository;


    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public ResponseEntity<Company> getCompanyById(Long id) throws Exception {
        Company company = companyRepository.findCompanyById(id);
        if (company == null){
            LOGGER.info("Tour with " + id + " not found");
            throw new CompanyNotFoundException(String.format("Tour with %d not found", id)); // якщо не знайшов кидай помилку
        }
        return new ResponseEntity<>(company, HttpStatus.OK );
    }

    public ResponseEntity<String> deletedCompanyById(Long id){
        companyRepository.deleteById(id);
        LOGGER.info("Deleted tour");
        return new ResponseEntity<>("Deleted tour", HttpStatus.OK);
    }

    public void updateCompany(Company newCompany) {
        Company company = companyRepository.findCompanyById(newCompany.getId());
        update(company, newCompany);
        LOGGER.info("Updated with: " + newCompany.getId());
        companyRepository.save(company);

    }

    public void update(Company company, Company newCompany){
        company.setCompanyName(newCompany.getCompanyName());
        company.setUsers(newCompany.getUsers());

    }

        public ResponseEntity<String> addCompany(Company company){
            companyRepository.save(company);
            return new ResponseEntity<>("Added", HttpStatus.OK);
        }
}
