package practice.quikr.p_hibernate_em.sellerOnboarding.service.impl;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.hibernate4.Hibernate4Module;

import practice.quikr.p_hibernate_em.sellerOnboarding.dao.BankDao;
import practice.quikr.p_hibernate_em.sellerOnboarding.dao.CityDao;
import practice.quikr.p_hibernate_em.sellerOnboarding.dao.QuikrUserDao;
import practice.quikr.p_hibernate_em.sellerOnboarding.dao.SellerDao;
import practice.quikr.p_hibernate_em.sellerOnboarding.dto.BankDTO;
import practice.quikr.p_hibernate_em.sellerOnboarding.dto.CityDTO;
import practice.quikr.p_hibernate_em.sellerOnboarding.dto.QuikrUserDTO;
import practice.quikr.p_hibernate_em.sellerOnboarding.dto.SellerDTO;
import practice.quikr.p_hibernate_em.sellerOnboarding.service.SellerService;
import practice.quikr.p_hibernate_em.sellerOnboarding.vo.Commission;
import practice.quikr.p_hibernate_em.sellerOnboarding.vo.Seller;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
@Qualifier("sellerService")
public class SellerServiceImpl implements SellerService {

    public static final Logger LOGGER = LoggerFactory.getLogger(SellerServiceImpl.class);
    public static final String SELLER_APPROVAL_URI = "%s:%s/quikr/seller/%s/approve/view";

    @Autowired
    private SellerDao sellerDao;

    @Autowired
    private BankDao bankDao;

    @Autowired
    private QuikrUserDao quikrUserDao;

    @Autowired
    private CityDao cityDao;
/*
    @Autowired
    private NotificationService notificationService;

    @Autowired
    private DoorstepNotificationService doorstepNotificationService;

    @Autowired
    private UserService userService;
    
      @Autowired
    private QuikrAdditionalAttributeService quikrAdditionalAttributeService;

    @Autowired
    private CategoryService categoryService;

*/
    @Autowired
    private Environment environment;

      @Override
    public String save(Seller seller) {
    	LOGGER.info(" seller {}", seller); //TODO delete this log line
        StringBuilder response = new StringBuilder();
        ObjectMapper mapper = new ObjectMapper();
        SellerDTO sellerDTO = mapper.convertValue(seller, SellerDTO.class);
        LOGGER.info("coverted to sellerDTO {}", sellerDTO); //TODO delete this log line
        Set<QuikrUserDTO> quikrUsers = sellerDTO.getAllowedQuikrUsers();
        if (quikrUsers != null) {
            List<Long> discardedQuikrUsers = new ArrayList();
            quikrUsers.forEach(quikrUser -> {
                    QuikrUserDTO existingQuikrUser = quikrUserDao.getById(quikrUser.getId());
                    if (existingQuikrUser != null) {
                        BeanUtils.copyProperties(quikrUser, existingQuikrUser);
                        quikrUserDao.update(existingQuikrUser);
                    } else {
                        quikrUserDao.save(quikrUser);
                    }

            });
        }
        BankDTO bank = sellerDTO.getBank();
        if (bank != null) {
            BankDTO existingBankAccountDetails = bankDao.findById(bank.getId());
            if (existingBankAccountDetails != null) {
                bankDao.update(bank);
            } else {
                bankDao.save(bank);
            }
        }

        Set<CityDTO> cities = sellerDTO.getCities();
        if (cities != null) {
            cities.forEach(city -> {
                CityDTO existingCity = cityDao.getById(city.getId());
                if (existingCity != null) {
                    cityDao.update(city);
                } else {
                    cityDao.save(city);
                }

            });
        }
        seller = mapper.convertValue(sellerDao.save(sellerDTO), Seller.class);
        if(StringUtils.isEmpty(response.toString())) {
            response.append("Seller saved successfully with ID ").append(seller.getId());
        }
        return response.toString();
    }

    @Override
    public Seller update(Seller seller) {
        SellerDTO existingSeller = sellerDao.fetch(seller.getId());
        if(!existingSeller.isActive()) {
            throw new IllegalArgumentException("Seller is not more active. Update failed.");
        }
        ObjectMapper mapper = new ObjectMapper();
        SellerDTO sellerDTO = mapper.convertValue(seller, SellerDTO.class);
        seller = mapper.convertValue(sellerDao.update(sellerDTO), Seller.class);
        return seller;
    }

    @Override
    public Seller fetch(Long id) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(JsonInclude.Include.NON_DEFAULT);
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        mapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
        mapper.registerModule(new Hibernate4Module());
        SellerDTO sellerDTO = sellerDao.fetch(id);
        Seller seller = null;
        if (sellerDTO != null) {
            seller = mapper.convertValue(sellerDTO, Seller.class);
        }
        return seller;
    }

    @Override
    public List<Seller> getByQuikrUser(Long id) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(JsonInclude.Include.NON_DEFAULT);
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        mapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
        mapper.registerModule(new Hibernate4Module());
        QuikrUserDTO quikrUser = quikrUserDao.getActiveUsersById(id);
        if (quikrUser != null) {
            List<Seller> masterVOs = new ArrayList();
            Set<SellerDTO> masters = quikrUser.getMasters();
            LOGGER.info("Fetched master for quikr user ID {} is {}", id, masters);
            masters.forEach(master -> masterVOs.add(mapper.convertValue(master, Seller.class)));
            return masterVOs;
        }
        return null;
    }

    @Override
    public void approveSeller(Long id) {
        SellerDTO existingSeller = sellerDao.fetch(id);
        LOGGER.debug("Existing seller found for ID {}. Approving seller.", id);
        if (existingSeller == null) {
            throw new IllegalArgumentException("Seller not found with ID " + id);
        }
        existingSeller.setAssured(true);//isAssured(existingSeller.getEmail(), existingSeller.getAllowedSubCategoryIds()));
        existingSeller.setApproved(true);
        existingSeller.setApprovedBy("Sarath"); //TODO find logged-in user
        sellerDao.update(existingSeller);
    }

    @Override
    public void softDelete(Long sellerId) {
        SellerDTO existingSeller = sellerDao.fetch(sellerId);
        LOGGER.debug("Existing seller found for ID {}. Performing soft-delete.", sellerId);
        if (existingSeller == null) {
            throw new IllegalArgumentException("Seller not found with ID " + sellerId);
        }
        Set<QuikrUserDTO> quikrUsers = existingSeller.getAllowedQuikrUsers();
        if (quikrUsers != null) {
            quikrUsers.forEach(quikrUser -> {
                quikrUser.setActive(false);
            });
        }
        existingSeller.setActive(false);
        sellerDao.update(existingSeller);
    }
    
    private void mapCommision(Seller source, SellerDTO target) {
    	Commission commission=source.getCommission();
    	if(commission!=null) {
    		target.setCommission(commission.getCommission());
    		target.setCommissionStarttime(commission.getStarttime());
    		target.setCommissionExpirytime(commission.getExpirytime());
    	}
    }
    
    private void mapCommision(SellerDTO source, Seller target) {
    	Commission commission = target.getCommission();
    	if(commission == null) {
    		commission = new Commission();
    	}
    	commission.setCommission(source.getCommission());
    	commission.setStarttime(source.getCommissionExpirytime());
    	commission.setExpirytime(source.getCommissionExpirytime());
    }
}
