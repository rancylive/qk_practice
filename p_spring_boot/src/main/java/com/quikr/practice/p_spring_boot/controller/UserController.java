package com.quikr.practice.p_spring_boot.controller;

import ch.qos.logback.classic.Logger;

import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.quikr.practice.p_spring_boot.service.UserService;
import com.quikr.practice.p_spring_boot.vo.User1;

//@RestController
//@RequestMapping("/user/")
public class UserController {

	private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService service;

	@RequestMapping(value = "add", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public User1 addUser(@RequestBody User1 user) {
		LOGGER.info("Adding user: {}", user);
		return service.add(user);
	}

	@RequestMapping(value = "{name}", method = RequestMethod.GET)
	public List<User1> fetchByName(@PathVariable String name) {
		LOGGER.info("Fetching user by name: {}", name);
		return service.fetchByName(name);
	}
}
