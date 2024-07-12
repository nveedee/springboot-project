package ch.axa.springbootproject.repositories;
import org.springframework.data.jpa.repository.JpaRepository;

import ch.axa.springbootproject.domain.Agent;

public interface AgentRepository extends JpaRepository<Agent, Integer> {
    
}
