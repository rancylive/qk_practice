package practice.quikr.p_spring_hbm.sellerOnboarding.vo;

import java.util.List;

import practice.quikr.p_spring_hbm.sellerOnboarding.enums.Role;

public class QuikrUser {
    private String ssoId;
    private String emailId;
    private String phoneNumber;
    private List<Role> roles;

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

    @Override
    public String toString() {
        return "QuikrUserDTO{" +
                "ssoId='" + ssoId + '\'' +
                ", emailId='" + emailId + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", roles=" + roles +
                '}';
    }
}
