package practice.quikr.p_spring_hbm.sellerOnboarding.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import practice.quikr.p_spring_hbm.sellerOnboarding.dao.SellerDao;
import practice.quikr.p_spring_hbm.sellerOnboarding.dto.SellerDTO;
import practice.quikr.p_spring_hbm.sellerOnboarding.service.SellerService;
import practice.quikr.p_spring_hbm.sellerOnboarding.vo.Seller;

import java.util.List;

@Service
@Qualifier("sellerService")
public class SellerServiceImpl implements SellerService {

    @Autowired
    private SellerDao sellerDao;

    public Seller save(Seller seller) {
        SellerDTO sellerDTO = new SellerDTO();
        BeanUtils.copyProperties(seller, sellerDTO);
        sellerDao.save(sellerDTO);
        return seller;
    }

    public Seller update(Seller seller) {
        SellerDTO sellerDTO = new SellerDTO();
        BeanUtils.copyProperties(seller, sellerDTO);
        sellerDao.update(sellerDTO);
        return seller;
    }

    public Seller fetch(Long id) {
        SellerDTO sellerDTO = sellerDao.fetch(id);
        Seller seller  = null;
        if(sellerDTO != null) {
            seller = new Seller();
            BeanUtils.copyProperties(sellerDTO,seller);
        }
        new Seller();
        BeanUtils.copyProperties(sellerDTO,seller);
        return seller;
    }

    public Seller getByQuikrUser(String ssoid) {
        List<SellerDTO> sellerDTO = sellerDao.getByQuikrUser(ssoid);
        Seller seller  = null;
        if(sellerDTO != null && sellerDTO.get(0) != null) {
            seller = new Seller();
            BeanUtils.copyProperties(sellerDTO.get(0),seller);
        }
        BeanUtils.copyProperties(sellerDTO,seller);
        return seller;
    }
}
