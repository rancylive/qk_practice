package practice.quikr.p_hibernate_em.sellerOnboarding.dao;

import practice.quikr.p_hibernate_em.sellerOnboarding.dto.CityDTO;

public interface CityDao {
    CityDTO getById(int id);
    CityDTO save(CityDTO cityDTO);
    CityDTO update(CityDTO cityDTO);
}
