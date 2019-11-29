package com.quikr.practice.p_spring_boot.selleronboard.entityManager;

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

@RestController
public class SellerControllerNew {
	@Autowired
	private SellerServiceNew sellerServiceNew;
	
	@RequestMapping(value = "/quikr/seller/onboard", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public SellerDTO add(@RequestBody SellerDTO seller) {
		return sellerServiceNew.save(seller);
	}
}
