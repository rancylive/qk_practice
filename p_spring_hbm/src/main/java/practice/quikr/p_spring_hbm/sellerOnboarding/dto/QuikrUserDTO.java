package practice.quikr.p_spring_hbm.sellerOnboarding.dto;

import practice.quikr.p_spring_hbm.sellerOnboarding.enums.*;
import javax.persistence.*;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "quikr_user")
public class QuikrUserDTO {
    @Id
    private String ssoId;
    private String emailId;
    private String phoneNumber;
    @ElementCollection
    private List<Role> roles;
    @JsonIgnore
    @ManyToMany(mappedBy = "allowedQuikrUsers")
    private List<SellerDTO> masters;

    public String getSsoId() {
        return ssoId;
    }

    public void setSsoId(String ssoId) {
        this.ssoId = ssoId;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public List<SellerDTO> getMasters() {
        return masters;
    }

    public void setMasters(List<SellerDTO> masters) {
        this.masters = masters;
    }

    @Override
    public String toString() {
        return "QuikrUserDTO{" +
                "ssoId='" + ssoId + '\'' +
                ", emailId='" + emailId + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", roles=" + roles +
                ", masters=" + masters +
                '}';
    }
}
