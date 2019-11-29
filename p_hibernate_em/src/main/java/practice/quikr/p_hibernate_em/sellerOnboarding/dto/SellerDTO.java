package practice.quikr.p_hibernate_em.sellerOnboarding.dto;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import practice.quikr.p_hibernate_em.sellerOnboarding.enums.Type;

@Entity
@Table(name = "seller")
@JsonIgnoreProperties(ignoreUnknown = true)
public class SellerDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @JsonProperty("babelUserId")
    @Column(name = "babel_user_id")
    private Long babelUserId;

    @JsonProperty("assured")
    @Column(name = "assured")
    private boolean assured;

    @JsonProperty("approved")
    @Column(name = "approved")
    private boolean approved = false;

    @JsonProperty("approvedBy")
    @Column(name = "approved_by")
    private String approvedBy;

    @JsonProperty("active")
    @Column(name = "is_active")
    private boolean active = true;

    @JsonProperty("type")
    @Column(name = "type")
    private Type type;

    @JsonProperty("email")
    @Column(name = "email")
    private String email;

    @JsonProperty("phoneNumber")
    @Column(name = "phoneNumber")
    private String phoneNumber;

    @OneToOne(fetch = FetchType.LAZY, orphanRemoval = true)
    @JoinColumn(name = "accountNumber", referencedColumnName = "accountNumber")
    @Cascade(org.hibernate.annotations.CascadeType.MERGE)
    @JsonProperty("bank")
    private BankDTO bank;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "seller_cities", joinColumns = {@JoinColumn(name = "seller_id", referencedColumnName = "id")}, inverseJoinColumns = {@JoinColumn(name = "cities_id", referencedColumnName = "id")})
    @Cascade(org.hibernate.annotations.CascadeType.MERGE)
    @JsonProperty("cities")
    private Set<CityDTO> cities;

    @JsonProperty("commission.commission")
    @Column(name = "commission")
    private double commission;

    @JsonProperty("commission.starttime")
    @Column(name = "commission_starttime")
    private Date commissionStarttime;
    
    @JsonProperty("commission.expirytime")
    @Column(name = "commission_expirytime")
	private Date commissionExpirytime;
	
    @JsonProperty("allowedCategoryId")
    @Column(name = "allowed_category_id")
    private Long allowedCategoryId;

    @ElementCollection(fetch = FetchType.LAZY)
    @JsonProperty("allowedSubCategoryIds")
    @Column(name = "allowed_sub_category_ids")
    private Set<Long> allowedSubCategoryIds;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "seller_allowed_quikr_users", joinColumns = {@JoinColumn(name = "masters_id", referencedColumnName = "id")}, inverseJoinColumns = {@JoinColumn(name = "allowed_quikr_users_id", referencedColumnName = "id")})
    @Cascade(org.hibernate.annotations.CascadeType.MERGE)
    @JsonProperty("allowedQuikrUsers")
    private Set<QuikrUserDTO> allowedQuikrUsers;


    @JsonProperty("createdby")
    @Column(name = "createdby")
    private String createdby;

    @JsonProperty("updatedby")
    @Column(name = "updatedby")
    private String updatedby;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @JsonProperty("createdTime")
    @Column(name = "createdTime")
    private Date createdTime;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @JsonProperty("updatedTime")
    @Column(name = "updatedTime")
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

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
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

    public BankDTO getBank() {
        return bank;
    }

    public void setBank(BankDTO bank) {
        this.bank = bank;
    }

    public Set<CityDTO> getCities() {
        return cities;
    }

    public void setCities(Set<CityDTO> cities) {
        this.cities = cities;
    }

    public double getCommission() {
		return commission;
	}

	public void setCommission(double commission) {
		this.commission = commission;
	}

	public Date getCommissionStarttime() {
		return commissionStarttime;
	}

	public void setCommissionStarttime(Date commissionStarttime) {
		this.commissionStarttime = commissionStarttime;
	}

	public Date getCommissionExpirytime() {
		return commissionExpirytime;
	}

	public void setCommissionExpirytime(Date commissionExpirytime) {
		this.commissionExpirytime = commissionExpirytime;
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

    public Set<QuikrUserDTO> getAllowedQuikrUsers() {
        return allowedQuikrUsers;
    }

    public void setAllowedQuikrUsers(Set<QuikrUserDTO> allowedQuikrUsers) {
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
        return "SellerDTO{" +
                "id=" + id +
                ", babelUserId=" + babelUserId +
                ", assured=" + assured +
                ", approved=" + approved +
                ", approvedBy='" + approvedBy + '\'' +
                ", active=" + active +
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
