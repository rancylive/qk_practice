package practice.quikr.p_spring_hbm.sellerOnboarding.dao.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import practice.quikr.p_spring_hbm.sellerOnboarding.dao.SellerDao;
import practice.quikr.p_spring_hbm.sellerOnboarding.dto.QuikrUserDTO;
import practice.quikr.p_spring_hbm.sellerOnboarding.dto.SellerDTO;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository("sellerDao")
@Transactional("escrow_c2c")
public class SellerDaoImpl implements SellerDao {
    public static final Logger LOGGER = LoggerFactory.getLogger(SellerDaoImpl.class);

    @PersistenceContext(unitName = "h2Data")//"c2cEntityManagerFactory")
    EntityManager em;

    public SellerDTO save(SellerDTO sellerDTO) {
        LOGGER.info("Saving seller {}",sellerDTO);
        em.persist(sellerDTO);
        em.flush();
        return sellerDTO;
    }

    public SellerDTO update(SellerDTO sellerDTO) {
        LOGGER.info("Updating seller {}",sellerDTO);
        em.merge(sellerDTO);
        em.flush();
        return sellerDTO;
    }

    public SellerDTO fetch(Long id) {
        return em.find(SellerDTO.class, id);
    }

    public List<SellerDTO> getByQuikrUser(String ssoId) {
        QuikrUserDTO quikrUser = em.find(QuikrUserDTO.class, ssoId);
        if(quikrUser != null) {
            return quikrUser.getMasters();
        }
        return null;
    }
}
