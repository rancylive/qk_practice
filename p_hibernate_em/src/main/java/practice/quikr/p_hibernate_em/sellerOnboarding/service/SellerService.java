package practice.quikr.p_hibernate_em.sellerOnboarding.service;

import java.util.List;

import practice.quikr.p_hibernate_em.sellerOnboarding.vo.Seller;

public interface SellerService {
    String save(Seller seller);
    Seller update(Seller seller);
    Seller fetch(Long id);
    List<Seller> getByQuikrUser(Long babelUserId);
    void approveSeller(Long sellerId);

    void softDelete(Long sellerId);
}
