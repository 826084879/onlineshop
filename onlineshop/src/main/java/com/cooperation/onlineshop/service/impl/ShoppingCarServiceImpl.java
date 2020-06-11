package com.cooperation.onlineshop.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.cooperation.onlineshop.common.UuidUtil;
import com.cooperation.onlineshop.entity.ShoppingCar;
import com.cooperation.onlineshop.entity.Shoppingcar2good;
import com.cooperation.onlineshop.mapper.ShoppingCarMapper;
import com.cooperation.onlineshop.mapper.Shoppingcar2goodMapper;
import com.cooperation.onlineshop.service.ShoppingCarService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cooperation.onlineshop.service.Shoppingcar2goodService;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author CQRenMin
 * @since 2020-05-23
 */
@Service
public class ShoppingCarServiceImpl extends ServiceImpl<ShoppingCarMapper, ShoppingCar> implements ShoppingCarService {

    @Resource
    ShoppingCarService shoppingCarService;
    @Resource
    Shoppingcar2goodService shoppingcar2goodService;
    @Resource
    ShoppingCarMapper shoppingCarMapper;
    @Resource
    Shoppingcar2goodMapper shoppingcar2goodMapper;


    @Override
    public ShoppingCar findShoppingCarByName(String name) {
        return shoppingCarMapper.findShoppingCarByName(name);
    }

    @Override
    public List<Map<String,Object>> getShoppingCarDetailMsg(String condition) {
        Map<String,Object> map = JSONObject.fromObject(condition);
        return shoppingCarMapper.getShoppingCarDetailMsg(map);
    }

    @Transactional
    @Override
    public boolean add2ShoppingCar(ShoppingCar shoppingCar,String goodsId) {

        QueryWrapper<ShoppingCar> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("customer_id",shoppingCar.getCustomerId());
        ShoppingCar one = shoppingCarService.getOne(queryWrapper);
        if (one==null){//没有就新增一个购物车
            shoppingCar.setId(UuidUtil.getShortUuid());
            shoppingCarService.save(shoppingCar);
        }

        Shoppingcar2good shoppingcar2good = new Shoppingcar2good();
        shoppingcar2good.setId(UuidUtil.getShortUuid());
        if (one==null){
            shoppingcar2good.setLeftId(shoppingCar.getId());
        }else {
            shoppingcar2good.setLeftId(one.getId());
        }
        shoppingcar2good.setRightId(goodsId);
        shoppingcar2good.setGoodCount(1);

        return shoppingcar2goodService.save(shoppingcar2good);
    }

    @Override
    public boolean removeShoppingCar(String goodsId,String shppingCarId) {
        //关联表去除
        UpdateWrapper<Shoppingcar2good> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("left_id",shppingCarId).eq("right_id",goodsId);
        return shoppingcar2goodService.remove(updateWrapper);
    }


    @Transactional
    @Override
    public boolean clearShoppingCar(String shoppingCarId) {
        UpdateWrapper<Shoppingcar2good> updateWrapper = new UpdateWrapper<>();
        updateWrapper.in("left_id",shoppingCarId);
        return shoppingcar2goodService.remove(updateWrapper);
    }

    @Override
    public boolean changeGoodsCount(String shoppingCarId, String goodsId, boolean addFlag) {
        UpdateWrapper<Shoppingcar2good> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("left_id",shoppingCarId).eq("right_id",goodsId);

        //获取当前数量
        QueryWrapper<Shoppingcar2good> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("left_id",shoppingCarId).eq("right_id",goodsId);
        Shoppingcar2good one = shoppingcar2goodService.getOne(queryWrapper);

        if (addFlag){
            updateWrapper.set("good_count", one.getGoodCount() + 1);
        }else {
            updateWrapper.set("good_count", one.getGoodCount() - 1);
        }
        shoppingcar2goodService.update(updateWrapper);
        return false;
    }
}
