package ch.axa.springbootproject.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ch.axa.springbootproject.domain.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    
}