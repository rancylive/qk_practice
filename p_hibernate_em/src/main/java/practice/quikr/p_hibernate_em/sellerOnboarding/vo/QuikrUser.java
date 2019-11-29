package practice.quikr.p_hibernate_em.sellerOnboarding.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import practice.quikr.p_hibernate_em.sellerOnboarding.enums.Role;

import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
public class QuikrUser {
    private Long id;
    private String email;
    private String phoneNumber;
    private Set<Role> roles;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "QuikrUser{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", roles=" + roles +
                '}';
    }
}
