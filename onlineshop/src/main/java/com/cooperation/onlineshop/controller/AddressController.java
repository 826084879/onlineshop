package com.cooperation.onlineshop.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cooperation.onlineshop.entity.Address;
import com.cooperation.onlineshop.mapper.AddressMapper;
import com.cooperation.onlineshop.service.AddressService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author CQRenMin
 * @since 2020-06-14
 */
@RestController
@RequestMapping("/address")
public class AddressController {
    @Resource
    AddressMapper addressMapper;
    @Resource
    AddressService addressService;

    @GetMapping("query")
    public String queryAddresses(){
        QueryWrapper<Address> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("create_time");
        List<Address> addresses = addressMapper.selectList(queryWrapper);
        return addresses.toString();
    }

    @PostMapping("/add")
    public String addAddress(@RequestBody Address address, @RequestParam String customerId){
        return addressService.addAddress(address,customerId);
    }
}
