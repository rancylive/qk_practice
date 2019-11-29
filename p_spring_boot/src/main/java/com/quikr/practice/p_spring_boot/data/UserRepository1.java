package com.quikr.practice.p_spring_boot.data;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.quikr.practice.p_spring_boot.vo.User1;

public interface UserRepository1 extends JpaRepository<User1, Long>{
	List<User1> getByName(String name);
}
