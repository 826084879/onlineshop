package com.cooperation.onlineshop.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cooperation.onlineshop.entity.Goods;
import com.cooperation.onlineshop.mapper.GoodsMapper;
import com.cooperation.onlineshop.service.GoodsService;
import com.mysql.cj.xdevapi.JsonArray;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import static com.cooperation.onlineshop.common.UuidUtil.getShortUuid;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author CQRenMin
 * @since 2020-05-17
 */
@RestController
@RequestMapping("/goods")
public class GoodsController {
    private static final Logger LOGGER = LoggerFactory.getLogger(GoodsController.class);

    @Resource
    GoodsService goodsService;


    /**
     * 获取所有商品信息
     */
    @GetMapping("/getAll")
    public String getAll(@RequestParam String orderBy,boolean isAsc) {
        /*
        IPage<Goods> page = new Page<>(pageIndex, pageSize);
        QueryWrapper<Goods> wrapper = new QueryWrapper<>();
        if (!aesc){
            wrapper.orderByDesc(orderBy);
        }else{
            wrapper.orderByAsc(orderBy);
        }
        wrapper.setEntity(new Goods());
        IPage<Goods> page1 = goodsService.page(page, wrapper);

        for (int i = 0; i <page1.getSize() ; i++) {

        }

        return  page1;
         */
        JSONArray array = goodsService.getAllGoods(orderBy,isAsc);
        return array.toString();

    }

    /**
     * 获取单个商品信息商品信息
     */
    @GetMapping("/{id}")
    public Goods getGoodsByKey(@PathVariable("id") String id) {
        //获取前台发送过来的数据
        return goodsService.getById(id);
    }

    /**
     * 通过名字查询商品信息
     */
    @GetMapping("/queryGoods/{name}")
    public Object getGoodByName(@PathVariable("name") String name){
        return goodsService.getGoodByName(name);
    }


    /**
     * 新增商品
     * 注:modifytime參數不要
     */
    @RequestMapping(value = "/addGoods", method = RequestMethod.POST, headers = "content-type=multipart/form-data")
    public String addGoods(Goods goods, @RequestParam(value = "files",required = false) MultipartFile[] files, @RequestParam String img_location_json) {
        StringBuilder res = new StringBuilder();
//        goods.setId(getShortUuid()); 前台提供id
        //img_location_json  [{"fileName":"lz.jpg","location":"title"},{"fileName":"xg.jpg","location":"banner"},...]
        JSONArray object= JSONArray.fromObject(img_location_json);
        res.append(goodsService.addGoods(goods,files,object));
        return res.toString();
    }

    /**
     * 修改商品
     */
    @RequestMapping(value = "/updateGoods", method = RequestMethod.POST, headers = "content-type=multipart/form-data")
    public String updateGoods(Goods goods, @RequestParam(value = "files",required = false) MultipartFile[] files, @RequestParam String img_location_json) {
        StringBuilder res = new StringBuilder();
        //img_location_json  [{"fileName":"lz.jpg","location":"title"},{"fileName":"xg.jpg","location":"banner"},...]
        JSONArray object= JSONArray.fromObject(img_location_json);
        res.append(goodsService.updateGoods(goods,files,object));
        return res.toString();
    }
    /**
     * 删除商品
     */
    @DeleteMapping("/delGoods")
    public boolean delGoods(@PathVariable("id") String id){
        return goodsService.removeById(id);
    }

}
