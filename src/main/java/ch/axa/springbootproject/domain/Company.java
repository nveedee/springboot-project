package ch.axa.springbootproject.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Company")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

   
    private String name;

    
    private String adresse;

    private String mail;

    // Standard-Konstruktor
    public Company() {
    }

    // Konstruktor
    public Company(int id, String name, String adresse, String mail) {
        this.id = id;
        this.name = name;
        this.adresse = adresse;
        this.mail = mail;
    }

    // Getter und Setter für id
    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Getter und Setter für name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter und Setter für adresse
    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    // Getter und Setter für mail
    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
}
