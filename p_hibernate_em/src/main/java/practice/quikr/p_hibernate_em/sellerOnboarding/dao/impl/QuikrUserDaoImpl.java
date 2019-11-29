package practice.quikr.p_hibernate_em.sellerOnboarding.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import practice.quikr.p_hibernate_em.sellerOnboarding.dao.QuikrUserDao;
import practice.quikr.p_hibernate_em.sellerOnboarding.dto.QuikrUserDTO;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository("quikrUserDao")
@Transactional("escrow_c2c")
public class QuikrUserDaoImpl implements QuikrUserDao {
    public static final Logger LOGGER = LoggerFactory.getLogger(QuikrUserDaoImpl.class);

    @PersistenceContext(unitName = "c2cEntityManagerFactory")
    EntityManager em;

    public QuikrUserDTO getActiveUsersById(Long id) {
        {
            Session session = (Session) em.getDelegate();
            Criteria criteria = session.createCriteria(QuikrUserDTO.class);
            criteria.add(Restrictions.eq("id", id));
            criteria.add(Restrictions.eq("active", true));
            return (QuikrUserDTO) criteria.uniqueResult();
        }
    }

    public QuikrUserDTO save(QuikrUserDTO quikrUserDTO) {
        em.persist(quikrUserDTO);
        em.flush();
        return quikrUserDTO;
    }

    public QuikrUserDTO update(QuikrUserDTO quikrUserDTO) {
        em.merge(quikrUserDTO);
        em.flush();
        return quikrUserDTO;
    }

    public QuikrUserDTO getById(Long id) {
        return em.find(QuikrUserDTO.class, id);
    }

}
