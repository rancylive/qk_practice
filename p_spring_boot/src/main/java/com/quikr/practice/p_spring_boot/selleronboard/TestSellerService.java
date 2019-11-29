package com.quikr.practice.p_spring_boot.selleronboard;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Arrays;

public class TestSellerService {
    public static void main(String[] args) {
        City city = new City();
        city.setAddress("KA");
        city.setName("BLR");
        Seller seller = new Seller();
        seller.setAllowedCategory(null);
        seller.setCities(Arrays.asList(city));
        seller.setAllowedList(null);
        seller.setEmail("soem@Some.com");
        ObjectMapper mapper=new ObjectMapper();
        SellerDTO sellerDTO = mapper.convertValue(seller, SellerDTO.class);
        System.out.println(sellerDTO);
    }
}
