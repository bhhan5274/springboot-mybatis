package com.bhhan.mybatis.springbootmybatis.repository.shop;

import com.bhhan.mybatis.springbootmybatis.domain.Shop;
import com.bhhan.mybatis.springbootmybatis.web.dto.ShopRequestDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by hbh5274@gmail.com on 2020-01-13
 * Github : http://github.com/bhhan5274
 */

@Mapper
public interface ShopRepository {
    List<Shop> list();

    Long add(Shop shop);

    Shop findByShopNo(Long shopNo);

    Long modify(Shop shop);

    Long delete(Long shopNo);
}
