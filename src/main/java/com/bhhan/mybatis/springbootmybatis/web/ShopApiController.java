package com.bhhan.mybatis.springbootmybatis.web;

import com.bhhan.mybatis.springbootmybatis.service.ShopService;
import com.bhhan.mybatis.springbootmybatis.web.dto.ShopRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by hbh5274@gmail.com on 2020-01-13
 * Github : http://github.com/bhhan5274
 */

@RestController
@RequiredArgsConstructor
public class ShopApiController {

    private final ShopService shopService;

    @PostMapping("/shop/add")
    public Long add(@RequestBody ShopRequestDto shop){
        return shopService.add(shop);
    }
}
