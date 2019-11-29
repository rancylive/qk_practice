package com.quikr.practice.p_spring_boot.data;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quikr.practice.p_spring_boot.vo.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer>{
	Department getById(int id);
}
