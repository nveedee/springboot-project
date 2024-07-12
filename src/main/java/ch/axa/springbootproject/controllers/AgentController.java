package ch.axa.springbootproject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import ch.axa.springbootproject.domain.Agent;
import ch.axa.springbootproject.repositories.AgentRepository;



@RestController
@RequestMapping("/api/agents")
public class AgentController {

  @Autowired
  private AgentRepository agentRepository;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Agent create(@RequestBody @Validated Agent agent) {
    return agentRepository.save(agent);
  }

  @GetMapping
  public Iterable<Agent> index() {
    return agentRepository.findAll();
  }

  @GetMapping("/{id}")
  public ResponseEntity<Agent> read(@PathVariable int id) {
    return ResponseEntity.of(agentRepository.findById(id));
  }

  @PutMapping("/{id}")
  public Agent update(@PathVariable int id, @RequestBody @Validated Agent agent) {
    agent.setId(id);
    return agentRepository.save(agent);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Agent> delete(@PathVariable int id) {
    var agent = agentRepository.findById(id);
    if(agent.isPresent()) {
      agentRepository.delete(agent.get());
      return new ResponseEntity<>(HttpStatus.OK);
    }

    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }
}
