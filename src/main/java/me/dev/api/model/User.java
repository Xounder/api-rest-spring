package me.dev.api.model;

import java.math.BigDecimal;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity(name = "tb_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(precision = 13, scale = 2)
    private BigDecimal balance;

    @Column(precision = 13, scale = 2)
    private BigDecimal anotherBankBalance;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Sponsor> sponsors;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Feature> features;
    
    @OneToOne(cascade = CascadeType.ALL)
    private CreditCard creditCard;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getFirstName() {
        return name;
    }
    public void setFirstName(String name) {
        this.name = name;
    }
    public BigDecimal getBalance() {
        return balance;
    }
    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
    public BigDecimal getAnotherBankBalance() {
        return anotherBankBalance;
    }
    public void setAnotherBankBalance(BigDecimal anotherBankBalance) {
        this.anotherBankBalance = anotherBankBalance;
    }
    public List<Sponsor> getSponsors() {
        return sponsors;
    }
    public void setSponsors(List<Sponsor> sponsors) {
        this.sponsors = sponsors;
    }
    public List<Feature> getFeatures() {
        return features;
    }
    public void setFeatures(List<Feature> features) {
        this.features = features;
    }
    public CreditCard getCreditCard() {
        return creditCard;
    }
    public void setCreditCard(CreditCard creditCard) {
        this.creditCard = creditCard;
    }
}
