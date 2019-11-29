package practice.quikr.p_hibernate_em.sellerOnboarding.dto;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import practice.quikr.p_hibernate_em.sellerOnboarding.enums.Role;

@Entity
@Table(name = "quikr_user")
public class QuikrUserDTO {
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "email")
    private String email;

    @Column(name = "phone_number")
    private String phoneNumber;

    @ElementCollection(fetch = FetchType.LAZY)
    @Column(name = "roles")
    private Set<Role> roles;

    @JsonProperty("active")
    @Column(name = "is_active")
    private boolean active = true;

    @JsonIgnore
    @ManyToMany(mappedBy = "allowedQuikrUsers", fetch = FetchType.LAZY)
    private Set<SellerDTO> masters;

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

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Set<SellerDTO> getMasters() {
        return masters;
    }

    public void setMasters(Set<SellerDTO> masters) {
        this.masters = masters;
    }

    @Override
    public String toString() {
        return "QuikrUserDTO{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", roles=" + roles +
                ", active=" + active +
                '}';
    }
}
