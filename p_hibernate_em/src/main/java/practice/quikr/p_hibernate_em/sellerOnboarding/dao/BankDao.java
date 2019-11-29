package practice.quikr.p_hibernate_em.sellerOnboarding.dao;

import practice.quikr.p_hibernate_em.sellerOnboarding.dto.BankDTO;

public interface BankDao {
    BankDTO getByAccountNumber(String accountNumber);
    BankDTO save(BankDTO bankDTO);
    BankDTO update(BankDTO bankDTO);
	BankDTO findById(long id);
}
