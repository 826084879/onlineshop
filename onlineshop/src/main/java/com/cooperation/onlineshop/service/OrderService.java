package com.cooperation.onlineshop.service;

import com.cooperation.onlineshop.entity.Address;
import com.cooperation.onlineshop.entity.Goods;
import com.cooperation.onlineshop.entity.Linkman;
import com.cooperation.onlineshop.entity.Order;
import com.baomidou.mybatisplus.extension.service.IService;
import net.sf.json.JSONArray;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author CQRenMin
 * @since 2020-05-23
 */
public interface OrderService extends IService<Order> {

    String getOrderMsg(int status);
    String add2Order(String goodsMsg,String orderId);
    String removeFromOrder(String id);
    String updateOrder(String orderId,int payWay);
}
