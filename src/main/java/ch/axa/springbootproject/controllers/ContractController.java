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

import ch.axa.springbootproject.domain.Contract;
import ch.axa.springbootproject.repositories.ContractRepository;

@RestController
@RequestMapping("/api/contracts")

public class ContractController {
    @Autowired
    private ContractRepository contractRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Contract create(@RequestBody @Validated Contract contract) {
        return contractRepository.save(contract);
    }

    @GetMapping
    public Iterable<Contract> index() {
        return contractRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Contract> read(@PathVariable int id) {
        return ResponseEntity.of(contractRepository.findById((long) id));
    }

    @PutMapping("/{id}")
    public Contract update(@PathVariable int id, @RequestBody @Validated Contract contract) {
        contract.setId(id);
        return contractRepository.save(contract);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Contract> delete(@PathVariable int id) {
        var contract = contractRepository.findById((long) id);
        if(contract.isPresent()) {
            contractRepository.delete(contract.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}