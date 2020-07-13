package com.cooperation.onlineshop.controller;


import com.cooperation.onlineshop.common.UuidUtil;
import com.cooperation.onlineshop.entity.Address;
import com.cooperation.onlineshop.entity.Goods;
import com.cooperation.onlineshop.entity.Linkman;
import com.cooperation.onlineshop.entity.Order;
import com.cooperation.onlineshop.service.OrderService;
import com.mysql.cj.xdevapi.JsonArray;
import net.sf.json.JSONArray;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author CQRenMin
 * @since 2020-05-23
 */
@RestController
@RequestMapping("/order")
public class OrderController {
    @Resource
    OrderService orderService;

    @GetMapping("/query")
    public String getOrderMsg(@RequestParam int status){
        return orderService.getOrderMsg(status);
    }


    @PostMapping("/new")
    public String newOrder(@RequestBody Order order){
        order.setId(UuidUtil.getShortUuid());
        orderService.save(order);
        return order.toString();
    }

    @PostMapping("/add")
    public String add2Order(@RequestBody String shoppingCarMsg,@RequestParam String customerId){
        return orderService.add2Order(shoppingCarMsg,customerId);
    }

    @DeleteMapping("/delete/{id}")
    public String removeFromOrder(@PathVariable("id") String id){
        return orderService.removeFromOrder(id);
    }

    @PutMapping("/update")
    public String updateOrder(@RequestParam String orderId,int payWay){
        return orderService.updateOrder(orderId,payWay);
    }
}
