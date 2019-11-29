package com.quikr.practice.p_spring_boot.selleronboard;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

@Entity(name = "SELLER")
public class SellerDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id")
    @Column(name = "id")
    private Long id;

    @JsonProperty("assured")
    @Column(name = "assured")
    private boolean assured;

    @JsonProperty("type")
    @Column(name = "type")
    private Type type;

    @JsonProperty("email")
    @Column(name = "email")
    private String email;

    @JsonProperty("phoneNumber")
    @Column(name = "phoneNumber")
    private String phoneNumber;

    @OneToOne
    @JoinColumn(name = "accountNumber", referencedColumnName = "accountNumber")
    @Cascade(org.hibernate.annotations.CascadeType.MERGE)
    @JsonProperty("bank")
    private BankDTO bank;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "seller_cities", joinColumns = {@JoinColumn(name = "seller_id", referencedColumnName = "id")}, inverseJoinColumns = {@JoinColumn(name = "cities_id", referencedColumnName = "id")})
    @Cascade(org.hibernate.annotations.CascadeType.MERGE)
    @JsonProperty("cities")
    private List<CityDTO> cities;

    @JsonProperty("commission")
    @Column(name = "commission")
    private int commission;

    @JsonProperty("allowedCategory")
    @Column(name = "allowed_category")
    private AllowedCategory allowedCategory;

    @ElementCollection
    @JsonProperty("allowedList")
    @Column(name = "allowed_list")
    private List<String> allowedList;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "seller_allowed_quikr_users", joinColumns = {@JoinColumn(name = "masters_id", referencedColumnName = "id")}, inverseJoinColumns = {@JoinColumn(name = "allowed_quikr_users_sso_id", referencedColumnName = "sso_id")})
    @Cascade(org.hibernate.annotations.CascadeType.MERGE)
    @JsonProperty("allowedQuikrUsers")
    private List<QuikrUserDTO> allowedQuikrUsers;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isAssured() {
        return assured;
    }

    public void setAssured(boolean assured) {
        this.assured = assured;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public BankDTO getBank() {
        return bank;
    }

    public void setBank(BankDTO bank) {
        this.bank = bank;
    }

    public List<CityDTO> getCities() {
        return cities;
    }

    public void setCities(List<CityDTO> cities) {
        this.cities = cities;
    }

    public int getCommission() {
        return commission;
    }

    public void setCommission(int commission) {
        this.commission = commission;
    }

    public AllowedCategory getAllowedCategory() {
        return allowedCategory;
    }

    public void setAllowedCategory(AllowedCategory allowedCategory) {
        this.allowedCategory = allowedCategory;
    }

    public List<String> getAllowedList() {
        return allowedList;
    }

    public void setAllowedList(List<String> allowedList) {
        this.allowedList = allowedList;
    }

    public List<QuikrUserDTO> getAllowedQuikrUsers() {
        return allowedQuikrUsers;
    }

    public void setAllowedQuikrUsers(List<QuikrUserDTO> allowedQuikrUsers) {
        this.allowedQuikrUsers = allowedQuikrUsers;
    }

    @Override
    public String toString() {
        return "SellerDTO{" +
                "id=" + id +
                ", assured=" + assured +
                ", type=" + type +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", bank=" + bank +
                ", cities=" + cities +
                ", commission=" + commission +
                ", allowedCategory=" + allowedCategory +
                ", allowedList=" + allowedList +
                ", allowedQuikrUsers=" + allowedQuikrUsers +
                '}';
    }
}
