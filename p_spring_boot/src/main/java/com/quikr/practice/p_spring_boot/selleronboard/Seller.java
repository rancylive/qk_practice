package com.quikr.practice.p_spring_boot.selleronboard;

import java.util.List;

public class Seller {

    private Long id;
    private boolean assured;
    private Type type;
    private String email;
    private String phoneNumber;
    private Bank bank;
    private List<City> cities;
    private int commission;
    private AllowedCategory allowedCategory;
    private List<String> allowedList;
    private List<QuikrUser> allowedQuikrUsers;

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
        assured = assured;
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

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public List<City> getCities() {
        return cities;
    }

    public void setCities(List<City> cities) {
        cities = cities;
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

    public List<QuikrUser> getAllowedQuikrUsers() {
        return allowedQuikrUsers;
    }

    public void setAllowedQuikrUsers(List<QuikrUser> allowedQuikrUsers) {
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
                ", Cities=" + cities +
                ", commission=" + commission +
                ", allowedCategory=" + allowedCategory +
                ", allowedList=" + allowedList +
                ", allowedQuikrUsers=" + allowedQuikrUsers +
                '}';
    }
}
