package com.cooperation.onlineshop.service;

import com.cooperation.onlineshop.entity.ShoppingCar;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author CQRenMin
 * @since 2020-05-23
 */
public interface ShoppingCarService extends IService<ShoppingCar> {
    boolean clearShoppingCar(String shoppingCarId);
    boolean changeGoodsCount(String shoppingCarId,String goodsId,boolean addFlag);
    ShoppingCar findShoppingCarByName(String name);
    List<Map<String,Object>> getShoppingCarDetailMsg(String condition);
    boolean add2ShoppingCar(ShoppingCar shoppingCar,String goodsId);
    boolean removeShoppingCar(String goodsId,String shppingCarId);

}
