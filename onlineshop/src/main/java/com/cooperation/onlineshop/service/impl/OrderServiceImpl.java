package com.cooperation.onlineshop.service.impl;

import com.cooperation.onlineshop.entity.Order;
import com.cooperation.onlineshop.mapper.OrderMapper;
import com.cooperation.onlineshop.service.OrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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

}
