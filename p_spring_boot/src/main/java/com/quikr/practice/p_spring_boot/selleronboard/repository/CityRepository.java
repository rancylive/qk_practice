package com.quikr.practice.p_spring_boot.selleronboard.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quikr.practice.p_spring_boot.selleronboard.City;

public interface CityRepository extends JpaRepository<City, Long>{
	public City getById(int id);
}
