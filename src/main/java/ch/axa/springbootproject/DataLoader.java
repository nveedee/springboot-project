package ch.axa.springbootproject;

import ch.axa.springbootproject.domain.Agent;
import ch.axa.springbootproject.domain.Company;
import ch.axa.springbootproject.domain.Contract;
import ch.axa.springbootproject.domain.Customer;
import ch.axa.springbootproject.domain.Product;
import ch.axa.springbootproject.repositories.AgentRepository;
import ch.axa.springbootproject.repositories.CompanyRepository;
import ch.axa.springbootproject.repositories.ContractRepository;
import ch.axa.springbootproject.repositories.CustomerRepository;
import ch.axa.springbootproject.repositories.ProductRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.Arrays;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private AgentRepository agentRepository;

    @Autowired
    private ContractRepository contractRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public void run(String... args) throws Exception {
        if (productRepository.count() == 0) {
            // Create some sample products
            Product product1 = new Product();
            product1.setName("Product 1");
            product1.setPremiumCalculation(10.0);

            Product product2 = new Product();
            product2.setName("Product 2");
            product2.setPremiumCalculation(20.0);

            Product product3 = new Product();
            product3.setName("Product 3");
            product3.setPremiumCalculation(30.0);

            productRepository.saveAll(Arrays.asList(product1, product2, product3));
        }

        if (customerRepository.count() == 0) {
            Customer customer1 = new Customer();
            customer1.setFirstName("John");
            customer1.setLastName("Doe");
            customer1.setPhoneNumber("123456789");

            Customer customer2 = new Customer();
            customer2.setFirstName("Jane");
            customer2.setLastName("Doe");
            customer2.setPhoneNumber("987654321");

            Customer customer3 = new Customer();
            customer3.setFirstName("Max");
            customer3.setLastName("Mustermann");
            customer3.setPhoneNumber("123123123");

            customerRepository.saveAll(Arrays.asList(customer1, customer2, customer3));
        }

        if (agentRepository.count() == 0) {
            Agent agent1 = new Agent();
            agent1.setFirstName("Agent");
            agent1.setLastName("Smith");
            agent1.setInsuranceArea("Area 1");

            Agent agent2 = new Agent();
            agent2.setFirstName("Agent");
            agent2.setLastName("Johnson");
            agent2.setInsuranceArea("Area 2");

            Agent agent3 = new Agent();
            agent3.setFirstName("Agent");
            agent3.setLastName("Brown");
            agent3.setInsuranceArea("Area 3");

            agentRepository.saveAll(Arrays.asList(agent1, agent2, agent3));
        }

        if(contractRepository.count() == 0) {
            // Create some sample contracts
            Contract contract1 = new Contract();
            contract1.setContractNumber("C123456");
            contract1.setStartDate(Date.valueOf("2021-01-01"));
            contract1.setEndDate(Date.valueOf("2022-01-01"));
            contract1.setInsuranceType("Health Insurance");
            contract1.setAgent(agentRepository.findById(1).get());

            Contract contract2 = new Contract();
            contract2.setContractNumber("C654321");
            contract2.setStartDate(Date.valueOf("2021-01-01"));
            contract2.setEndDate(Date.valueOf("2022-01-01"));
            contract2.setInsuranceType("Car Insurance");
            contract2.setAgent(agentRepository.findById(2).get());

            Contract contract3 = new Contract();
            contract3.setContractNumber("C987654");
            contract3.setStartDate(Date.valueOf("2021-01-01"));
            contract3.setEndDate(Date.valueOf("2022-01-01"));
            contract3.setInsuranceType("Home Insurance");
            contract3.setAgent(agentRepository.findById(3).get());
    
        
            

            contractRepository.saveAll(Arrays.asList(contract1, contract2, contract3));
        }

        if(companyRepository.count() == 0) {
            Company company1 = new Company();
            company1.setName("Sigma health");
            company1.setAdresse("Skibidistreet 123");
            company1.setMail("sigma@health.com");

            Company company2 = new Company();
            company2.setName("Alpha car");
            company2.setAdresse("Vroomstreet 456");
            company2.setMail("alpha@car.com");

            Company company3 = new Company();
            company3.setName("Omega home");
            company3.setAdresse("Housestreet 789");
            company3.setMail("omega@home.com");

           
            companyRepository.saveAll(Arrays.asList(company1, company2, company3));
        }
    }
}
