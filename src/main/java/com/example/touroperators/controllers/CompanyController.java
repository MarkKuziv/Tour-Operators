package com.example.touroperators.controllers;

import com.example.touroperators.Services.CompanyService;
import com.example.touroperators.entities.Company;
import com.example.touroperators.entities.Tour;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CompanyController {
    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping(value = "/company/{id}")
    public ResponseEntity<Company> getCompanyById(@PathVariable long id) throws Exception {
        return companyService.getCompanyById(id);
    }

    @PostMapping(value = "/company/add",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> addCompany(@RequestBody Company company){
        return companyService.addCompany(company);
    }

    @DeleteMapping(value = "/company/deleted/{id}")
    public ResponseEntity<String> deletedCompanyById(@PathVariable long id){
        return companyService.deletedCompanyById(id);
    }

    @PutMapping(value = "/company/update")
    public void updateCompany(@RequestBody Company company){
        companyService.updateCompany(company);
    }
}
