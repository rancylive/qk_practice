package com.quikr.practice.p_spring_boot.selleronboard.entityManager;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.quikr.practice.p_spring_boot.selleronboard.QuikrUser;
import com.quikr.practice.p_spring_boot.selleronboard.SellerDTO;

@Repository("sellerDao")
@Transactional
public class SellerDao {
    @PersistenceContext(unitName = "entityManagerFactory") //c2cEntityManagerFactory")
    EntityManager em;

    public SellerDTO save(SellerDTO sellerDTO) {
        em.persist(sellerDTO);
        em.flush();
        return sellerDTO;
    }

    public SellerDTO update(SellerDTO sellerDTO) {
        em.merge(sellerDTO);
        em.flush();
        return sellerDTO;
    }

    public SellerDTO fetch(Long id) {
        return em.find(SellerDTO.class, id);
    }

    public List<SellerDTO> getByQuikrUser(String ssoId) {
        QuikrUser quikrUser = em.find(QuikrUser.class, ssoId);
        if(quikrUser != null) {
            return quikrUser.getMasters();
        }
        return null;
    }
}
