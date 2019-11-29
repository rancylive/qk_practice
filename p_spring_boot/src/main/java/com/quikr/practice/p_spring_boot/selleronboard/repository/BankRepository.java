package com.quikr.practice.p_spring_boot.selleronboard.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quikr.practice.p_spring_boot.selleronboard.Bank;

public interface BankRepository extends JpaRepository<Bank, Long>{
	public Bank getByAccountNumber(String accountNumber);
}
