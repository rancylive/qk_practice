package practice.quikr.p_hibernate_em.sellerOnboarding.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import practice.quikr.p_hibernate_em.sellerOnboarding.dao.SellerDao;
import practice.quikr.p_hibernate_em.sellerOnboarding.dto.SellerDTO;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository("sellerDao")
@Transactional("escrow_c2c")
public class SellerDaoImpl implements SellerDao {
    public static final Logger LOGGER = LoggerFactory.getLogger(SellerDaoImpl.class);

    @PersistenceContext(unitName = "c2cEntityManagerFactory")
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
        Session session = (Session) em.getDelegate();
        Criteria criteria = session.createCriteria(SellerDTO.class);
        criteria.add(Restrictions.eq("id", id));
        criteria.add(Restrictions.eq("active", true));
        return (SellerDTO) criteria.uniqueResult();
    }

}
