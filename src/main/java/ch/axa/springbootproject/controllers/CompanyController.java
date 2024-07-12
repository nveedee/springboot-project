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

import ch.axa.springbootproject.domain.Company;
import ch.axa.springbootproject.repositories.CompanyRepository;

@RestController
@RequestMapping("/api/companies")
public class CompanyController {

  @Autowired
  private CompanyRepository companyRepository;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Company create(@RequestBody @Validated Company company) {
    return companyRepository.save(company);
  }

  @GetMapping
  public Iterable<Company> index() {
    return companyRepository.findAll();
  }

  @GetMapping("/{id}")
  public ResponseEntity<Company> read(@PathVariable int id) {
    return ResponseEntity.of(companyRepository.findById((long) id));
  }

  @PutMapping("/{id}")
  public Company update(@PathVariable int id, @RequestBody @Validated Company company) {
    company.setId(id);
    return companyRepository.save(company);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Company> delete(@PathVariable int id) {
    var company = companyRepository.findById((long) id);
    if(company.isPresent()) {
      companyRepository.delete(company.get());
      return new ResponseEntity<>(HttpStatus.OK);
    }

    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
}
}