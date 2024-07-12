package ch.axa.springbootproject.domain;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long productId;

    
    private String name;

    private String description;

    private double premiumCalculation;


    // Beziehung zu Contract
    @OneToMany(mappedBy = "product")
    private List<Contract> contracts;

    // Standard-Konstruktor
    public Product() {
    }

    // Konstruktor
    public Product(int productId, String name, String description, double premiumCalculation) {
        this.productId = productId;
        this.name = name;
        this.description = description;
        this.premiumCalculation = premiumCalculation;
    }

    // Getters and Setters
    public long getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPremiumCalculation() {
        return premiumCalculation;
    }

    public void setPremiumCalculation(double premiumCalculation) {
        this.premiumCalculation = premiumCalculation;
    }

    public List<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(List<Contract> contracts) {
        this.contracts = contracts;
    }

    public void setId(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setId'");
    }
}
