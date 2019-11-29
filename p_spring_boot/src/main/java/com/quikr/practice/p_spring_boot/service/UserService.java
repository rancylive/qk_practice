package com.quikr.practice.p_spring_boot.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quikr.practice.p_spring_boot.data.AddressRepository;
import com.quikr.practice.p_spring_boot.data.DepartmentRepository;
import com.quikr.practice.p_spring_boot.data.UserRepository1;
import com.quikr.practice.p_spring_boot.utils.BeanCopyUtil;
import com.quikr.practice.p_spring_boot.vo.Address;
import com.quikr.practice.p_spring_boot.vo.Department;
import com.quikr.practice.p_spring_boot.vo.User1;

//@Service
public class UserService {
	@Autowired
	private UserRepository1 repository;
	
	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Autowired
	private AddressRepository addressRepository;
	
	public User1 add(User1 user) {
		Department department = user.getDepartment();
		if(department != null && department.getId() > 0) {
			Department existingDepr = departmentRepository.getById(department.getId());
			if(existingDepr == null) {
				throw new IllegalArgumentException("No department found by id "+department.getId());
			}
			BeanCopyUtil.copy(department, existingDepr);
			user.setDepartment(existingDepr);
		}
		List<Address> addresses = user.getAddress();
		if(addresses != null) {
			List<Address> updateAddress = new ArrayList<Address>();
			addresses.forEach(addres -> {
				if(addres.getId() > 0 ) {
					Address existingAddress = addressRepository.getById(addres.getId());
					if(existingAddress != null) {
						BeanCopyUtil.copy(addres, existingAddress);
						updateAddress.add(existingAddress);
					} else {
						addres.setId(0);
						updateAddress.add(addres);
					}
				} else {
					addres.setId(0);
					updateAddress.add(addres);
				}
			});
			user.setAddress(updateAddress);
		}
		repository.save(user);
		return user;
	}
	
	public List<User1> fetchByName(String name) {
		return repository.getByName(name);
	}
}
