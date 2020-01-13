package com.bhhan.mybatis.springbootmybatis.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Created by hbh5274@gmail.com on 2020-01-13
 * Github : http://github.com/bhhan5274
 */

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Shop {
    private Long shopNo;
    private String shopName;
    private String shopLocation;
    private String shopStatus;

    @Builder
    public Shop(Long shopNo, String shopName, String shopLocation, String shopStatus){
        this.shopNo = shopNo;
        this.shopName = shopName;
        this.shopLocation = shopLocation;
        this.shopStatus = shopStatus;
    }

    @Override
    public String toString() {
        return "Shop{" +
                "shopNo=" + shopNo +
                ", shopName='" + shopName + '\'' +
                ", shopLocation='" + shopLocation + '\'' +
                ", shopStatus='" + shopStatus + '\'' +
                '}';
    }
}
