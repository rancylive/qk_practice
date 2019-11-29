package com.quikr.practice.p_spring_boot.selleronboard;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name = "QUIKR_USER")
public class QuikrUser {

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

}
