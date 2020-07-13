package com.cooperation.onlineshop.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cooperation.onlineshop.entity.Address;
import com.cooperation.onlineshop.entity.Linkman;
import com.cooperation.onlineshop.mapper.LinkmanMapper;
import com.cooperation.onlineshop.service.LinkmanService;
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
@RequestMapping("/linkman")
public class LinkmanController {

    @Resource
    LinkmanMapper linkmanMapper;
    @Resource
    LinkmanService linkmanService;

    @GetMapping("query")
    public String queryLinkman(){
        QueryWrapper<Linkman> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("create_time");
        List<Linkman> addresses = linkmanMapper.selectList(queryWrapper);
        return addresses.toString();
    }

    @PostMapping("/add")
    public String addLinkMan(@RequestBody Linkman linkman, @RequestParam String customerId){
        return linkmanService.addLinkMan(linkman,customerId);
    }


}
