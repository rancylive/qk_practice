package practice.quikr.p_spring_hbm.sellerOnboarding.vo;

import javax.persistence.Entity;
import javax.persistence.Id;

public class Bank {
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
