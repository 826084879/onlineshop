package com.cooperation.onlineshop.service.impl;

import com.cooperation.onlineshop.entity.Customer;
import com.cooperation.onlineshop.mapper.CustomerMapper;
import com.cooperation.onlineshop.service.CustomerService;
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
public class CustomerServiceImpl extends ServiceImpl<CustomerMapper, Customer> implements CustomerService {

}
