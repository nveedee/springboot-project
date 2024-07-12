package ch.axa.springbootproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ch.axa.springbootproject.domain.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {
  
}