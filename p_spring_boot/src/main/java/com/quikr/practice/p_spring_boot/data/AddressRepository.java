package com.quikr.practice.p_spring_boot.data;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quikr.practice.p_spring_boot.vo.Address;

public interface AddressRepository extends JpaRepository<Address, Long>{
	public Address getById(int id);
}
