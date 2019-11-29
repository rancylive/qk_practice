package practice.quikr.p_spring_hbm.sellerOnboarding.dto;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import practice.quikr.p_spring_hbm.sellerOnboarding.enums.*;
@Entity
@Table(name="seller")
public class SellerDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private boolean isAssured;
    private Type type;
    private String email;
    private String phoneNumber;
    @OneToOne(cascade = CascadeType.ALL)
    @JsonProperty("bank")
    private BankDTO bankDTO;
    @ManyToMany(cascade = CascadeType.ALL)
    private List<CityDTO> Cities;
    private int commission;
    private AllowedCategory allowedCategory;
    @ElementCollection
    private List<String> allowedList;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonProperty("allowedQuikrUsers")
    private List<QuikrUserDTO> allowedQuikrUserDTOS;

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

    public BankDTO getBankDTO() {
        return bankDTO;
    }

    public void setBankDTO(BankDTO bankDTO) {
        this.bankDTO = bankDTO;
    }

    public List<CityDTO> getCities() {
        return Cities;
    }

    public void setCities(List<CityDTO> cities) {
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

    public List<QuikrUserDTO> getAllowedQuikrUserDTOS() {
        return allowedQuikrUserDTOS;
    }

    public void setAllowedQuikrUserDTOS(List<QuikrUserDTO> allowedQuikrUserDTOS) {
        this.allowedQuikrUserDTOS = allowedQuikrUserDTOS;
    }

    @Override
    public String toString() {
        return "SellerDTO{" +
                "id=" + id +
                ", isAssured=" + isAssured +
                ", type=" + type +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", bankDTO=" + bankDTO +
                ", Cities=" + Cities +
                ", commission=" + commission +
                ", allowedCategory=" + allowedCategory +
                ", allowedList=" + allowedList +
                ", allowedQuikrUserDTOS=" + allowedQuikrUserDTOS +
                '}';
    }
}
