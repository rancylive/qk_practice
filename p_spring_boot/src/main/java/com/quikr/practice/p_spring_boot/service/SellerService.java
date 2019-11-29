package com.quikr.practice.p_spring_boot.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quikr.practice.p_spring_boot.selleronboard.Bank;
import com.quikr.practice.p_spring_boot.selleronboard.City;
import com.quikr.practice.p_spring_boot.selleronboard.QuikrUser;
import com.quikr.practice.p_spring_boot.selleronboard.SellerDTO;
import com.quikr.practice.p_spring_boot.selleronboard.repository.BankRepository;
import com.quikr.practice.p_spring_boot.selleronboard.repository.CityRepository;
import com.quikr.practice.p_spring_boot.selleronboard.repository.QuikrUserRepository;
import com.quikr.practice.p_spring_boot.selleronboard.repository.UserRepository;

//@Service
public class SellerService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private QuikrUserRepository quikrUserRepository;
	
	@Autowired
	private BankRepository bankRepository;
	
	@Autowired
	private CityRepository cityRepository;
	
	public SellerDTO add(SellerDTO user) {
		Bank bank = user.getBank();
		if(bank!=null) {
			Bank existingBankAccountDetails = bankRepository.getByAccountNumber(bank.getAccountNumber());
			if(existingBankAccountDetails!=null) {
				BeanUtils.copyProperties(bank, existingBankAccountDetails);
				user.setBank(existingBankAccountDetails);
			}
		}
		List<QuikrUser> quikrUsers = user.getAllowedQuikrUsers();
		if(quikrUsers!=null) {
			List<QuikrUser> updatedQuikrUser = new ArrayList<QuikrUser>();
			quikrUsers.forEach(quikrUser -> {
				QuikrUser existingQuikrUser = quikrUserRepository.getBySsoId(quikrUser.getSsoId());
				if(existingQuikrUser!=null) {
					BeanUtils.copyProperties(quikrUser, existingQuikrUser);
					updatedQuikrUser.add(existingQuikrUser);
				} else {
					updatedQuikrUser.add(quikrUser);
				}
			});
			user.setAllowedQuikrUsers(updatedQuikrUser);
		}
		List<City> cities = user.getCities();
		if(cities!=null) {
			List<City> updatedCities = new ArrayList<City>();
			cities.forEach(city->{
				if(city.getId()>0) {
					City existingCity = cityRepository.getById(city.getId());
					BeanUtils.copyProperties(city, existingCity);
					updatedCities.add(existingCity);
				} else {
					city.setId(0);
					updatedCities.add(city);
				}

			});
		}
		return userRepository.save(user);
	}
	
	public List<SellerDTO> getMaster(String ssoId) {
		QuikrUser quikrUser = quikrUserRepository.getBySsoId(ssoId);
		if(quikrUser != null) {
			return quikrUser.getMasters();
		}
		return null;
	}
	
}
