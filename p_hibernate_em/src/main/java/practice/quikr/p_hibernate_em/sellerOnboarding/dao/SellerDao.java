package practice.quikr.p_hibernate_em.sellerOnboarding.dao;


import practice.quikr.p_hibernate_em.sellerOnboarding.dto.SellerDTO;

public interface SellerDao {
    SellerDTO save(SellerDTO sellerDTO);
    SellerDTO update(SellerDTO sellerDTO);
    SellerDTO fetch(Long babelUserId);
}
