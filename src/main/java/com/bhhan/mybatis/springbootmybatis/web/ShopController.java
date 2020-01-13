package com.bhhan.mybatis.springbootmybatis.web;

import com.bhhan.mybatis.springbootmybatis.domain.Shop;
import com.bhhan.mybatis.springbootmybatis.service.ShopService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * Created by hbh5274@gmail.com on 2020-01-13
 * Github : http://github.com/bhhan5274
 */

@Controller
@RequiredArgsConstructor
public class ShopController {

    private final ShopService shopService;

    @GetMapping("/shop/list")
    public String list(Model model){

        final List<Shop> shops = shopService.find();
        if(shops.isEmpty()){
            model.addAttribute("isEmpty", true);
        }

        model.addAttribute("shops", shops);

        return "/shop/list";
    }

    @GetMapping("/shop/add")
    public String add(){
        return "/shop/add";
    }
}
