package com.bhhan.mybatis.springbootmybatis.web;

import com.bhhan.mybatis.springbootmybatis.domain.Shop;
import com.bhhan.mybatis.springbootmybatis.service.ShopService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

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

    @GetMapping("/shop/view/{shopNo}")
    public String view(@PathVariable Long shopNo, Model model){
        final Shop shop = shopService.findByShopNo(shopNo);

        model.addAttribute("shopName", shop.getShopName());
        model.addAttribute("shopLocation", shop.getShopLocation());
        model.addAttribute("shopStatus", shop.getShopStatus());

        return "/shop/view";
    }

    @GetMapping("/shop/modify/{shopNo}")
    public String modify(@PathVariable Long shopNo, Model model){
        final Shop shop = shopService.findByShopNo(shopNo);

        model.addAttribute("shopNo", shop.getShopNo());
        model.addAttribute("shopName", shop.getShopName());
        model.addAttribute("shopLocation", shop.getShopLocation());

        if(shop.getShopStatus().equalsIgnoreCase("Y")){
            model.addAttribute("shopStatus", shop.getShopStatus());
        }

        return "/shop/modify";
    }
}
