package com.cooperation.onlineshop.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cooperation.onlineshop.common.UuidUtil;
import com.cooperation.onlineshop.entity.Kind2goods;
import com.cooperation.onlineshop.entity.Kinds;
import com.cooperation.onlineshop.mapper.KindsMapper;
import com.cooperation.onlineshop.service.GoodsService;
import com.cooperation.onlineshop.service.Kind2goodsService;
import com.cooperation.onlineshop.service.KindsService;
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
@RequestMapping("/kinds")
public class KindsController {
    @Resource
    KindsService kindsService;
    @Resource
    KindsMapper kindsMapper;
    @Resource
    Kind2goodsService kind2goodsService;

    /**
     * 查询种类
     */
    @GetMapping("/getAll")
    public String getAll(){
        List<Kinds> kinds = kindsMapper.selectList(new QueryWrapper<>());
        return kinds.toString();
    }

    /**
     * 新增种类
     */
    @PostMapping("/add")
    public String addKind(@RequestParam String name) {
        String res="";
        try {
            QueryWrapper<Kinds> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("name",name);
            Kinds one = kindsService.getOne(queryWrapper);
            if (one==null){
                Kinds kinds = new Kinds();
                kinds.setId(UuidUtil.getShortUuid());
                kinds.setName(name);
                kindsService.save(kinds);
                res="OK";
            }else{
                res="种类"+name+"已存在!";
            }
        }catch (Exception e){
            res=e.getMessage();
        }
        return res;
    }

    /**
     * 修改种类
     */
    @PutMapping("/update")
    public String updateKind(@RequestBody Kinds kinds) {
        String res="";
        try {
            QueryWrapper<Kinds> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("name",kinds.getName()).ne("id",kinds.getId());

            Kinds one = kindsService.getOne(queryWrapper);
            if (one==null){
                Kinds kind = kindsService.getById(kinds.getId());;
                kind.setName(kinds.getName());
                kindsService.updateById(kind);
                res="OK";
            }else{
                res="种类"+kinds.getName()+"已存在!";
            }
        }catch (Exception e){
            res=e.getMessage();
        }
        return res;
    }

    /**
     * 删除种类
     */
    @DeleteMapping("/delete/{id}")
    public String deleteKind(@PathVariable(value = "id") String id) {
        String res="";
        try {
            QueryWrapper<Kind2goods> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("left_id",id);
            Kind2goods one = kind2goodsService.getOne(queryWrapper);
            if (one==null){
                kindsService.removeById(id);
                res="OK";
            }else{
                res="当前种类正在被使用!";
            }
        }catch (Exception e){
            res=e.getMessage();
        }
        return res;
    }
}
