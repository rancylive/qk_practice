package practice.quikr.p_spring_hbm.sellerOnboarding.service;

import java.util.List;

import practice.quikr.p_spring_hbm.sellerOnboarding.vo.Seller;

public interface SellerService {
    Seller save(Seller seller);
    Seller update(Seller seller);
    Seller fetch(Long id);
    Seller getByQuikrUser(String ssoid);

}
