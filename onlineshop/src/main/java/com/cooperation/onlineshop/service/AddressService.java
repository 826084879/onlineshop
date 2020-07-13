package com.cooperation.onlineshop.service;

import com.cooperation.onlineshop.entity.Address;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author CQRenMin
 * @since 2020-06-14
 */
public interface AddressService extends IService<Address> {
    String addAddress(Address address, String customerId);
}
