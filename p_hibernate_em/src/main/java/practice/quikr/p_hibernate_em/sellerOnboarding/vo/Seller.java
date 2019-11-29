package practice.quikr.p_hibernate_em.sellerOnboarding.vo;

import java.util.Date;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import practice.quikr.p_hibernate_em.sellerOnboarding.enums.Type;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Seller {

    private Long id;
    private Long babelUserId;
    private boolean assured;
    private boolean approved;
    private String approvedBy;
    private Type type;
    private String email;
    private String phoneNumber;
    private Bank bank; // no update
    private Set<City> cities;
    private Commission commission;// start and end time
    private Long allowedCategoryId;// no update
    private Set<Long> allowedSubCategoryIds;
    private Set<QuikrUser> allowedQuikrUsers;
    private String createdby;
    private String updatedby;
    private Date createdTime;
    private Date updatedTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBabelUserId() {
        return babelUserId;
    }

    public void setBabelUserId(Long babelUserId) {
        this.babelUserId = babelUserId;
    }

    public boolean isAssured() {
        return assured;
    }

    public void setAssured(boolean assured) {
        this.assured = assured;
    }

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }

    public String getApprovedBy() {
        return approvedBy;
    }

    public void setApprovedBy(String approvedBy) {
        this.approvedBy = approvedBy;
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

    public Set<City> getCities() {
        return cities;
    }

    public void setCities(Set<City> cities) {
        this.cities = cities;
    }

    public Commission getCommission() {
        return commission;
    }

    public void setCommission(Commission commission) {
        this.commission = commission;
    }

    public Long getAllowedCategoryId() {
        return allowedCategoryId;
    }

    public void setAllowedCategoryId(Long allowedCategoryId) {
        this.allowedCategoryId = allowedCategoryId;
    }

    public Set<Long> getAllowedSubCategoryIds() {
        return allowedSubCategoryIds;
    }

    public void setAllowedSubCategoryIds(Set<Long> allowedSubCategoryIds) {
        this.allowedSubCategoryIds = allowedSubCategoryIds;
    }

    public Set<QuikrUser> getAllowedQuikrUsers() {
        return allowedQuikrUsers;
    }

    public void setAllowedQuikrUsers(Set<QuikrUser> allowedQuikrUsers) {
        this.allowedQuikrUsers = allowedQuikrUsers;
    }

    public String getCreatedby() {
		return createdby;
	}

	public void setCreatedby(String createdby) {
		this.createdby = createdby;
	}

	public String getUpdatedby() {
		return updatedby;
	}

	public void setUpdatedby(String updatedby) {
		this.updatedby = updatedby;
	}

	public Date getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	public Date getUpdatedTime() {
		return updatedTime;
	}

	public void setUpdatedTime(Date updatedTime) {
		this.updatedTime = updatedTime;
	}

	@Override
    public String toString() {
        return "Seller{" +
                "id=" + id +
                ", babelUserId=" + babelUserId +
                ", assured=" + assured +
                ", approved=" + approved +
                ", approvedBy='" + approvedBy + '\'' +
                ", type=" + type +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", bank=" + bank +
                ", cities=" + cities +
                ", commission=" + commission +
                ", allowedCategoryId=" + allowedCategoryId +
                ", allowedSubCategoryIds=" + allowedSubCategoryIds +
                ", allowedQuikrUsers=" + allowedQuikrUsers +
                '}';
    }
}
