package practice.quikr.p_spring_hbm.sellerOnboarding.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bank")
public class BankDTO {
    @Id
    private String accountNumber;
    private String ifsc;
    private String accountHoldersName;

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getIfsc() {
        return ifsc;
    }

    public void setIfsc(String ifsc) {
        this.ifsc = ifsc;
    }

    public String getAccountHoldersName() {
        return accountHoldersName;
    }

    public void setAccountHoldersName(String accountHoldersName) {
        this.accountHoldersName = accountHoldersName;
    }

    @Override
    public String toString() {
        return "BankDTO{" +
                "accountNumber='" + accountNumber + '\'' +
                ", ifsc='" + ifsc + '\'' +
                ", accountHoldersName='" + accountHoldersName + '\'' +
                '}';
    }
}
