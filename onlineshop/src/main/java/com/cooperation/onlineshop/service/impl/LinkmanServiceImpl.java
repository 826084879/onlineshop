package com.cooperation.onlineshop.service.impl;

import com.cooperation.onlineshop.common.UuidUtil;
import com.cooperation.onlineshop.entity.Address;
import com.cooperation.onlineshop.entity.Customer2address;
import com.cooperation.onlineshop.entity.Customer2linkman;
import com.cooperation.onlineshop.entity.Linkman;
import com.cooperation.onlineshop.mapper.LinkmanMapper;
import com.cooperation.onlineshop.service.Customer2linkmanService;
import com.cooperation.onlineshop.service.LinkmanService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
public class LinkmanServiceImpl extends ServiceImpl<LinkmanMapper, Linkman> implements LinkmanService {

    @Resource
    LinkmanService linkmanService;
    @Resource
    Customer2linkmanService customer2linkmanService;

    public String addLinkMan(Linkman linkman,String customerId){
        String res= "";
        try{
            linkman.setId(UuidUtil.getShortUuid());
            linkman.setCreateTime(LocalDateTime.now());
            linkmanService.save(linkman);
            Customer2linkman customer2linkman= new Customer2linkman();
            customer2linkman.setId(UuidUtil.getShortUuid());
            customer2linkman.setLeftId(customerId);
            customer2linkman.setRightId(linkman.getId());
            customer2linkmanService.save(customer2linkman);
        }catch (Exception e){
            return e.getMessage();
        }
        return res;
    }


}
