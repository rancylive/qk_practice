package practice.quikr.p_hibernate_em.sellerOnboarding.dao.impl;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import practice.quikr.p_hibernate_em.sellerOnboarding.dao.CityDao;
import practice.quikr.p_hibernate_em.sellerOnboarding.dto.CityDTO;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository("cityDao")
@Transactional("escrow_c2c")
public class CityDaoImpl implements CityDao {
    public static final Logger LOGGER = LoggerFactory.getLogger(CityDaoImpl.class);

    @PersistenceContext(unitName = "c2cEntityManagerFactory")
    EntityManager em;

    public CityDTO getById(int id) {
        return em.find(CityDTO.class, id);
    }

    public CityDTO save(CityDTO cityDTO) {
        em.persist(cityDTO);
        em.flush();
        return cityDTO;
    }

    public CityDTO update(CityDTO cityDTO) {
        em.merge(cityDTO);
        em.flush();
        return cityDTO;
    }
}
