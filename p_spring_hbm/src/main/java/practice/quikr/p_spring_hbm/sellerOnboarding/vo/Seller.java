package practice.quikr.p_spring_hbm.sellerOnboarding.vo;
import javax.persistence.*;
import java.util.List;
import practice.quikr.p_spring_hbm.sellerOnboarding.enums.*;

public class Seller {

    private Long id;
    private boolean isAssured;
    private Type type;
    private String email;
    private String phoneNumber;
    private Bank bank;
    private List<City> Cities;
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
        return isAssured;
    }

    public void setAssured(boolean assured) {
        isAssured = assured;
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
        return Cities;
    }

    public void setCities(List<City> cities) {
        Cities = cities;
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
                ", isAssured=" + isAssured +
                ", type=" + type +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", bank=" + bank +
                ", Cities=" + Cities +
                ", commission=" + commission +
                ", allowedCategory=" + allowedCategory +
                ", allowedList=" + allowedList +
                ", allowedQuikrUsers=" + allowedQuikrUsers +
                '}';
    }
}
