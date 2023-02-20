package com.example.touroperators.repositories;

import com.example.touroperators.entities.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {
    Company findCompanyById(Long id);
    Company findCompanyByCompanyName(String name);
}
