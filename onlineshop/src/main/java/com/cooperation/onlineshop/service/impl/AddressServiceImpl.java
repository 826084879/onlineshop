package com.cooperation.onlineshop.service.impl;

import com.cooperation.onlineshop.common.UuidUtil;
import com.cooperation.onlineshop.entity.Address;
import com.cooperation.onlineshop.entity.Customer2address;
import com.cooperation.onlineshop.mapper.AddressMapper;
import com.cooperation.onlineshop.service.AddressService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cooperation.onlineshop.service.Customer2addressService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author CQRenMin
 * @since 2020-06-14
 */
@Service
public class AddressServiceImpl extends ServiceImpl<AddressMapper, Address> implements AddressService {
    @Resource
    AddressService addressService;
    @Resource
    Customer2addressService customer2addressService;

    public String addAddress(Address address, String customerId){
        String res= "";
        try{
            address.setId(UuidUtil.getShortUuid());
            address.setCreateTime(LocalDateTime.now());
            addressService.save(address);
            Customer2address customer2address= new Customer2address();
            customer2address.setId(UuidUtil.getShortUuid());
            customer2address.setLeftId(customerId);
            customer2address.setRightId(address.getId());
            customer2addressService.save(customer2address);
        }catch (Exception e){
            return e.getMessage();
        }
        return res;
    }
}
