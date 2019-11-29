package practice.quikr.p_hibernate_em.sellerOnboarding.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import practice.quikr.p_hibernate_em.sellerOnboarding.dao.BankDao;
import practice.quikr.p_hibernate_em.sellerOnboarding.dto.BankDTO;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository("bankDao")
@Transactional("escrow_c2c")
public class BankDaoImpl implements BankDao {
    public static final Logger LOGGER = LoggerFactory.getLogger(BankDaoImpl.class);

    @PersistenceContext(unitName = "c2cEntityManagerFactory")
    EntityManager em;

    @Override
    public BankDTO getByAccountNumber(String accountNumber) {
        Session session = (Session) em.getDelegate();
        Criteria criteria = session.createCriteria(BankDTO.class);
        criteria.add(Restrictions.eq("accountNumber", accountNumber));
        return (BankDTO) criteria.uniqueResult();
    }

    @Override
    public BankDTO findById(long id) {
        return em.find(BankDTO.class, id);
    }
    @Override
    public BankDTO save(BankDTO bankDTO) {
        em.persist(bankDTO);
        em.flush();
        return bankDTO;
    }

    @Override
    public BankDTO update(BankDTO bankDTO) {
        em.merge(bankDTO);
        em.flush();
        return bankDTO;
    }

}
