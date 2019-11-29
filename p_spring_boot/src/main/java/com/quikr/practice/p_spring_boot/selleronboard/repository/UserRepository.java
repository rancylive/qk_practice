package com.quikr.practice.p_spring_boot.selleronboard.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quikr.practice.p_spring_boot.selleronboard.SellerDTO;

public interface UserRepository extends JpaRepository<SellerDTO, Long>{

}
