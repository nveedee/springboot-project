package ch.axa.springbootproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ch.axa.springbootproject.domain.Contract;



@Repository
public interface ContractRepository extends JpaRepository<Contract, Long> {
    
}