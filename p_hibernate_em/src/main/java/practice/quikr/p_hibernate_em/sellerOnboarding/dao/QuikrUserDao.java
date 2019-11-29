package practice.quikr.p_hibernate_em.sellerOnboarding.dao;

import practice.quikr.p_hibernate_em.sellerOnboarding.dto.QuikrUserDTO;

public interface QuikrUserDao {
    QuikrUserDTO getActiveUsersById(Long id);
    QuikrUserDTO save(QuikrUserDTO quikrUserDTO);
    QuikrUserDTO update(QuikrUserDTO quikrUserDTO);
    QuikrUserDTO getById(Long id);
}
