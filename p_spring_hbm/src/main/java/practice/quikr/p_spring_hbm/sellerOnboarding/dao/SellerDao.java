package practice.quikr.p_spring_hbm.sellerOnboarding.dao;

import java.util.List;

import practice.quikr.p_spring_hbm.sellerOnboarding.dto.SellerDTO;

public interface SellerDao {
    SellerDTO save(SellerDTO sellerDTO);
    SellerDTO update(SellerDTO sellerDTO);
    SellerDTO fetch(Long id);
    List<SellerDTO> getByQuikrUser(String ssoId);
}
