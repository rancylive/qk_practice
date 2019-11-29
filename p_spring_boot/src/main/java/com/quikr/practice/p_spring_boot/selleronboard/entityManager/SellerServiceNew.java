package com.quikr.practice.p_spring_boot.selleronboard.entityManager;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.quikr.practice.p_spring_boot.selleronboard.SellerDTO;

@Service
@Qualifier("sellerService")
public class SellerServiceNew {

    @Autowired
    private SellerDao sellerDao;

    public SellerDTO save(SellerDTO seller) {
        sellerDao.save(seller);
        return seller;
    }

    public SellerDTO update(SellerDTO seller) {
        sellerDao.update(seller);
        return seller;
    }

    public SellerDTO fetch(Long id) {
        SellerDTO sellerDTO = sellerDao.fetch(id);
        return sellerDTO;
    }

    public SellerDTO getByQuikrUser(String ssoid) {
        List<SellerDTO> sellerDTO = sellerDao.getByQuikrUser(ssoid);
        SellerDTO seller  = null;
        if(sellerDTO != null && sellerDTO.get(0) != null) {
            seller = new SellerDTO();
            BeanUtils.copyProperties(sellerDTO.get(0),seller);
        }
        BeanUtils.copyProperties(sellerDTO,seller);
        return seller;
    }
}
