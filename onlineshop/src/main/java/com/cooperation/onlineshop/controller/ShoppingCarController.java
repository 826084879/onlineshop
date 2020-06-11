package com.cooperation.onlineshop.controller;


import com.cooperation.onlineshop.entity.ShoppingCar;
import com.cooperation.onlineshop.service.ShoppingCarService;
import net.sf.json.JSONObject;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author CQRenMin
 * @since 2020-05-23
 */
@RestController
@RequestMapping("/shoppingCar")
public class ShoppingCarController {

    @Resource
    ShoppingCarService shoppingCarService;

    //查询购物车
    @GetMapping("/query")
    public String queryShoppingCar(@RequestParam("condition") String condition) {
        if ("".equals(condition.trim())){
            condition="{}";
        }
        List<Map<String,Object>> mapList = shoppingCarService.getShoppingCarDetailMsg(condition);
        return mapList.toString();
    }



    //加入购物车
    @PostMapping("/add")
    public boolean addShoppingCar(@RequestBody ShoppingCar shoppingCar,@RequestParam String goodsId) {
        return shoppingCarService.add2ShoppingCar(shoppingCar,goodsId);
    }

    //增减商品数量
    @PutMapping("/changeGoodsCount")
    public String changeGoodsCount(@RequestParam String shoppingCarId, @RequestParam String goodsId, @RequestParam boolean addFlag) {
        boolean b = shoppingCarService.changeGoodsCount(shoppingCarId, goodsId, addFlag);
        return "OK";
    }

    //清空购物车
    @PostMapping("/clear")
    public String clearShoppingCar(@RequestParam String shoppingCarId) {
        JSONObject object = new JSONObject();

        boolean b = shoppingCarService.clearShoppingCar(shoppingCarId);
        if (b){
            object.put("RESULT","OK");
            object.put("CODE",200);
        }else{
            object.put("RESULT","Fail");
            object.put("CODE",400);
        }
        return object.toString();
    }

    //移除购物车
    @DeleteMapping("/remove")
    public boolean removeShoppingCar(@RequestParam String goodsId,@RequestParam String shppingCarId) {
        return shoppingCarService.removeShoppingCar(goodsId,shppingCarId);
    }

}
