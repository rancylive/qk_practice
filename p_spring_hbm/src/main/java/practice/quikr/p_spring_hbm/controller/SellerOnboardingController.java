package practice.quikr.p_spring_hbm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import practice.quikr.p_spring_hbm.sellerOnboarding.dto.SellerDTO;
import practice.quikr.p_spring_hbm.sellerOnboarding.service.SellerService;
import practice.quikr.p_spring_hbm.sellerOnboarding.vo.Seller;
@RestController
public class SellerOnboardingController {
	@Autowired
	private SellerService sellerService;
	
	@RequestMapping(value = "/quikr/seller/onboard", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Seller add(@RequestBody Seller seller) {
		return sellerService.save(seller);
	}
}
