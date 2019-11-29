package practice.quikr.p_hibernate_em.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import practice.quikr.p_hibernate_em.sellerOnboarding.service.SellerService;
import practice.quikr.p_hibernate_em.sellerOnboarding.vo.Seller;

@RestController
public class SellerController {
	@Autowired
	private SellerService sellerService;
	
	@RequestMapping(value = "/quikr/seller/onboard", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public String add(@RequestBody Seller seller) {
		return sellerService.save(seller);
	}
	@RequestMapping(value = "/quikr/seller/{id}", method = RequestMethod.GET)
	public Seller fetchMasterUser(@PathVariable Long id) {
		return sellerService.fetch(id);
	}
	@RequestMapping(value = "/quikr/user/{id}/master", method = RequestMethod.GET)
	public List<Seller> fetchMasterUser1(@PathVariable Long id) {
		return sellerService.getByQuikrUser(id);
	}
}
