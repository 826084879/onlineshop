package com.cooperation.onlineshop.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cooperation.onlineshop.entity.Files;
import com.cooperation.onlineshop.entity.Goods;
import com.cooperation.onlineshop.entity.Goods2files;
import com.cooperation.onlineshop.mapper.GoodsMapper;
import com.cooperation.onlineshop.service.FilesService;
import com.cooperation.onlineshop.service.Goods2filesService;
import com.cooperation.onlineshop.service.GoodsService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.mysql.cj.xdevapi.JsonArray;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;
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
    @Resource
    GoodsMapper goodsMapper;
    @Resource
    Goods2filesService goods2filesService;
    @Resource
    FilesService filesService;


    /**
     * 获取所有商品信息
     */
    @GetMapping("/getAll")
    public String getAll(@RequestParam String orderBy,boolean isAsc) throws JsonProcessingException {
        JSONArray array = goodsService.getAllGoods(orderBy,isAsc);
        return array.toString();
    }

    /**
     * 获取单个商品信息商品信息
     */
    @GetMapping("/{id}")
    public Map<String, Object> getGoodsByKey(@PathVariable("id") String id) {
        //获取前台发送过来的数据
        return goodsMapper.getGoodById(id);
    }

    /**
     * 通过名字查询商品信息
     */
    @GetMapping("/queryGoods/{name}")
    public Object getGoodByName(@PathVariable("name") String name){
        return goodsService.getGoodByName(name.trim());
    }


    /**
     * 新增商品
     * 注:modifytime參數不要
     */
    @PostMapping("/addGoods")
    public String addGoods(@RequestBody Goods goods,@RequestParam String kindName) {
        StringBuilder res = new StringBuilder();
        res.append(goodsService.addGoods(goods,kindName));
        return res.toString();
    }

    /**
     * 新增商品
     * 注:modifytime參數不要
     */
    @PutMapping("/publish")
    public String publishGoods(@RequestParam String goodsId) {
        return goodsService.publishGoods(goodsId);
    }

    /**
     * 修改商品
     */
    @PostMapping("/updateGoods")
    public String updateGoods(@RequestBody Goods goods) {
        StringBuilder res = new StringBuilder();
        res.append(goodsService.updateGoods(goods));
        return res.toString();
    }
    /**
     * 删除商品
     */
    @DeleteMapping("/delGoods")
    public boolean delGoods(@RequestParam("id") String id){
        return goodsService.removeById(id);
    }

}
