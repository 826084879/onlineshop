package com.cooperation.onlineshop;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cooperation.onlineshop.entity.Goods;
import com.cooperation.onlineshop.entity.ShoppingCar;
import com.cooperation.onlineshop.mapper.GoodsMapper;
import com.cooperation.onlineshop.service.ShoppingCarService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;


@SpringBootTest
class OnlineshopApplicationTests {


    @Autowired
    ShoppingCarService shoppingCarService;
    @Resource
    GoodsMapper goodsMapper;
    
    @Test
    public void findUser(){
        ShoppingCar shoppingCar= shoppingCarService.findShoppingCarByName("admin");
        System.out.println(shoppingCar.toString());
    }

    @Test
    void listTest(){
        List<Goods> goods = goodsMapper.selectList(new QueryWrapper<>());
        for (Goods good:goods) {
            System.out.println(good.getId());
        }
    }


}
