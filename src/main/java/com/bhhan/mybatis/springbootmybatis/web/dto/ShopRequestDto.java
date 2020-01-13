package com.bhhan.mybatis.springbootmybatis.web.dto;

import com.bhhan.mybatis.springbootmybatis.domain.Shop;
import lombok.Builder;
import lombok.Getter;

/**
 * Created by hbh5274@gmail.com on 2020-01-13
 * Github : http://github.com/bhhan5274
 */

@Getter
public class ShopRequestDto {
    private String shopName;
    private String shopLocation;
    private String shopStatus;

    @Builder
    public ShopRequestDto(String shopName, String shopLocation, String shopStatus){
        this.shopName = shopName;
        this.shopLocation = shopLocation;
        this.shopStatus = shopStatus;
    }

    @Override
    public String toString() {
        return "ShopRequestDto{" +
                "shopName='" + shopName + '\'' +
                ", shopLocation='" + shopLocation + '\'' +
                ", shopStatus='" + shopStatus + '\'' +
                '}';
    }

    public Shop toEntity(){
        return Shop.builder()
                .shopName(shopName)
                .shopLocation(shopLocation)
                .shopStatus(shopStatus)
                .build();
    }
}
