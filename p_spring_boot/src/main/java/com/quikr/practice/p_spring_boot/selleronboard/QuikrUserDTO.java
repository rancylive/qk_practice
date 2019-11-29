package com.quikr.practice.p_spring_boot.selleronboard;

public class QuikrUserDTO {
    @Id
    @Column(name = "sso_id")
    private String ssoId;

    @Column(name = "email_id")
    private String emailId;

    @Column(name = "phone_number")
    private String phoneNumber;

    @ElementCollection
    @Column(name = "roles")
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
