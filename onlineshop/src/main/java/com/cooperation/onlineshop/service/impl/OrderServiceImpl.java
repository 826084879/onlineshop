package com.cooperation.onlineshop.service.impl;

import ch.qos.logback.core.joran.spi.ElementSelector;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.cooperation.onlineshop.common.UuidUtil;
import com.cooperation.onlineshop.entity.*;
import com.cooperation.onlineshop.mapper.GoodsMapper;
import com.cooperation.onlineshop.mapper.OrderDetailMapper;
import com.cooperation.onlineshop.mapper.OrderMapper;
import com.cooperation.onlineshop.service.*;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import sun.java2d.d3d.D3DScreenUpdateManager;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.*;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author CQRenMin
 * @since 2020-05-23
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {

    @Resource
    OrderDetailService orderDetailService;
    @Resource
    OrderDetailMapper orderDetailMapper;
    @Resource
    GoodsMapper goodsMapper;
    @Resource
    OrderMapper orderMapper;
    @Resource
    OrderService orderService;

    @Override
    public String getOrderMsg(int status) {
        List<Map<String, Object>> list = new ArrayList<>();
        //通过訂單id查找商品信息
        QueryWrapper<Order> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("status",status);
        List<Order> orders = orderMapper.selectList(queryWrapper);
        if (orders.size()>0) {
            List<String> orderList = new ArrayList<>();
            for (Order order : orders) {
                orderList.add(order.getId());
            }

            if (orderList.size() > 0) {
                QueryWrapper<OrderDetail> queryWrapper1 =new QueryWrapper<>();
                queryWrapper1.in("left_id",orderList);
                List<OrderDetail> orderDetailList = orderDetailMapper.selectList(queryWrapper1);
                for (OrderDetail orderDetail : orderDetailList) {
                    Map<String, Object> goodById = goodsMapper.getGoodById(orderDetail.getRightId());
                    if (goodById!=null) {
                        list.add(goodById);
                    }
                }
            }
        }
        return list.toString();
    }



    @Override
    public String removeFromOrder(String id) {
        boolean b = orderService.removeById(id);
        if (b) {
            return "OK";
        }else{
            return "FAIL";
        }
    }

    /**
     * 更新订单 只能修改送货方式 目前不用管 未使用
     */
    @Override
    public String updateOrder(String orderId,int payWay) {
        try {
            UpdateWrapper<Order> updateWrapper = new UpdateWrapper<>();
            updateWrapper.eq("id",orderId);
            updateWrapper.set("sell_way",payWay);
            orderService.update(updateWrapper);
        }catch (Exception e){
            return e.getMessage();
        }
        return "OK";
    }

    /**
     * 新增订单
     */
    @Transactional
    @Override
    public String add2Order(String shoppingCarMsg,String customerId) {
        String tempId="";
        String strDateFormat = "YYYYMMDDHHmmss";
        SimpleDateFormat sdf = new SimpleDateFormat(strDateFormat);
        Date date = new Date();
        String code=sdf.format(date);
        JSONArray array = JSONArray.fromObject(shoppingCarMsg);
        //1.新增訂單
        Order order = new Order();
        order.setId(UuidUtil.getShortUuid());
        order.setCode(code+ String.format("%08d", new Random().nextInt(100000000) + 1));
        order.setCustomerId(customerId);
        order.setOrderTime(LocalDateTime.now());
        order.setPayWay(0);//1默认是微信支付
        order.setStatus(1);
        orderService.save(order);

        //2.订单关联变表数据新增
        List<OrderDetail> list= new ArrayList<>();
        for (int i = 0; i < array.size(); i++) {
            OrderDetail orderDetail = new OrderDetail();
            orderDetail.setId(UuidUtil.getShortUuid());
            orderDetail.setLeftId(order.getId());
            orderDetail.setRightId(array.getJSONObject(i).getString("goodId"));
            orderDetail.setGoodsCount(array.getJSONObject(i).getInt("count"));
            list.add(orderDetail);
        }
        orderDetailService.saveBatch(list);
        return tempId;
    }


}
