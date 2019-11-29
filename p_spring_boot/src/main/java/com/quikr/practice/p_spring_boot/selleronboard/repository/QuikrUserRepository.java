package com.quikr.practice.p_spring_boot.selleronboard.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quikr.practice.p_spring_boot.selleronboard.QuikrUser;

public interface QuikrUserRepository extends JpaRepository<QuikrUser, Long>{
	public QuikrUser getBySsoId(String ssoId);
}
