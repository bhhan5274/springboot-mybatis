package com.bhhan.mybatis.springbootmybatis.service;

import com.bhhan.mybatis.springbootmybatis.domain.Shop;
import com.bhhan.mybatis.springbootmybatis.repository.shop.ShopRepository;
import com.bhhan.mybatis.springbootmybatis.web.dto.ShopRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by hbh5274@gmail.com on 2020-01-13
 * Github : http://github.com/bhhan5274
 */

@Service
public class ShopService {

    @Autowired
    private ShopRepository shopRepository;


    @Transactional(readOnly = true)
    public List<Shop> find(){
        return shopRepository.list();
    }


    @Transactional
    public Long add(ShopRequestDto shopRequestDto){
        final Shop shop = shopRequestDto.toEntity();
        shopRepository.add(shop);
        return shop.getShopNo();
    }

    @Transactional(readOnly = true)
    public Shop findByShopNo(Long shopNo){
        return shopRepository.findByShopNo(shopNo);
    }

    @Transactional
    public Long modify(Shop shop){
        shopRepository.modify(shop);
        return shop.getShopNo();
    }

    @Transactional
    public Long delete(Long shopNo) {
        shopRepository.delete(shopNo);
        return shopNo;
    }
}
