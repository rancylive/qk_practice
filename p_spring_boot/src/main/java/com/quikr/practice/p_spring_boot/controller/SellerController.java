package com.quikr.practice.p_spring_boot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.quikr.practice.p_spring_boot.selleronboard.SellerDTO;
import com.quikr.practice.p_spring_boot.service.SellerService;

//@RestController
public class SellerController {
	@Autowired
	private SellerService sellerService;
	
	@RequestMapping(value = "/quikr/seller/onboard", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public SellerDTO add(@RequestBody SellerDTO user) {
		return sellerService.add(user);
	}
	@RequestMapping(value = "/quikr/users/{name}", method = RequestMethod.GET)
	public List<SellerDTO> fetchMasterUser(@PathVariable String name) {
		return sellerService.getMaster(name);
	}
	@RequestMapping(value = "/quikr/users1/{ssoId}", method = RequestMethod.GET)
	public List<SellerDTO> fetchMasterUser1(@PathVariable String ssoId) {
		return sellerService.getMaster(ssoId);
	}
}
