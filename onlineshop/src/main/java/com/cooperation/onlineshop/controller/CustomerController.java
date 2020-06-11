package com.cooperation.onlineshop.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cooperation.onlineshop.common.UuidUtil;
import com.cooperation.onlineshop.entity.Customer;
import com.cooperation.onlineshop.entity.Kinds;
import com.cooperation.onlineshop.service.CustomerService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author CQRenMin
 * @since 2020-05-23
 */
@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Resource
    CustomerService customerService;

    @PostMapping("/add")
    public String addCustomer(@RequestBody Customer customer){
        String res="";
        try {
            QueryWrapper<Customer> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("vx_number",customer.getVxNumber());
            Customer one = customerService.getOne(queryWrapper);
            if (one==null){
                customer.setId(UuidUtil.getShortUuid());
                customerService.save(customer);
            }else{
                res="微信号"+customer.getVxNumber()+"已存在!";
            }
        }catch (Exception e){
            res=e.getMessage();
        }
        return res;
    }

}
