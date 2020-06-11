package com.cooperation.onlineshop.mapper;

import com.cooperation.onlineshop.entity.ShoppingCar;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 * 联表查询采用mapper方式查询
 * @author CQRenMin
 * @since 2020-05-23
 */
public interface ShoppingCarMapper extends BaseMapper<ShoppingCar> {

    ShoppingCar findShoppingCarByName(@Param("userAccount") String name);
    List<Map<String,Object>> getShoppingCarDetailMsg(Map<String,Object> map);
    List<String> clearShoppingCar(String customerId);
    List<Map<String,Object>> getGoodByName(String name);
}
