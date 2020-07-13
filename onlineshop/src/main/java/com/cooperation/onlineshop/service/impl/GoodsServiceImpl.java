package com.cooperation.onlineshop.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.cooperation.onlineshop.common.LocalDateTimeSerializer;
import com.cooperation.onlineshop.common.UuidUtil;
import com.cooperation.onlineshop.entity.*;
import com.cooperation.onlineshop.mapper.*;
import com.cooperation.onlineshop.service.GoodsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cooperation.onlineshop.service.Kind2goodsService;
import com.cooperation.onlineshop.service.KindsService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author CQRenMin
 * @since 2020-05-18getAllGoods
 */
@Service
public class GoodsServiceImpl extends ServiceImpl<GoodsMapper, Goods> implements GoodsService {
    @Resource
    GoodsService goodsService;
    @Resource
    GoodsMapper goodsMapper;
    @Resource
    Kind2goodsMapper kind2goodsMapper;
    @Resource
    KindsMapper kindsMapper;
    @Resource
    Kind2goodsService kind2goodsService;
    @Resource
    CommentMapper commentMapper;
    @Resource
    Good2commentMapper good2commentMapper;


    @Transactional
    @Override
    public String addGoods(Goods goods,String kindName) {
        String res="";
        QueryWrapper<Kinds> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("name",kindName);
        Kinds kinds1 = kindsMapper.selectOne(queryWrapper);
        if (kinds1!=null) {
            //保存商品基本信息
            goods.setModifyTime(LocalDateTime.now());
            goods.setId(UuidUtil.getShortUuid());
            goods.setPublished(0);//默认不发布
            boolean save = goodsService.save(goods);

            if (save){
                Kind2goods kind2goods = new Kind2goods();
                kind2goods.setId(UuidUtil.getShortUuid());
                kind2goods.setLeftId(kinds1.getId());
                kind2goods.setRightId(goods.getId());
                boolean b = kind2goodsService.save(kind2goods);
                if (b){
                    res= "OK";
                }else {
                    res= "FAIL";
                }
            }
        }else{
            res="不存在对应的分类";
        }
        return res;
    }

    @Override
    public String publishGoods(String goodsId){
        String res="";
        try{
            UpdateWrapper<Goods> updateWrapper = new UpdateWrapper<>();
            updateWrapper.eq("id",goodsId);
            updateWrapper.set("published",1);
            if(goodsService.update(updateWrapper)){
                res= "OK";
            }
        }catch (Exception e){
            res= e.getMessage();
        }
        return res;
    }


    @Override
    public String updateGoods(Goods goods) {
        if (goodsService.getById(goods.getId())==null){
            return "商品唯一标识不存在";
        }

        //保存商品基本信息
        goods.setModifyTime(LocalDateTime.now());
        boolean b = goodsService.updateById(goods);
        if (b){
            return "OK";
        }else {
            return "FAIL";
        }
    }

    @Override
    public String getDetailGoodsMsg(String orderBy, boolean asc) {
        Map<String,Object> map = new HashMap<>();
        map.put("orderBy",orderBy);
        map.put("asc",asc);
        List<Map<String, Object>> detailGoodsMsg = goodsMapper.getDetailGoodsMsg(map);
        return detailGoodsMsg.toString();
    }

    @Override
    public List<Map<String,Object>> getGoodByName(String name) {
        return goodsMapper.getGoodByName(name);
    }

    @Override
    public JSONArray getAllGoods(String orderBy,boolean isAsc) throws JsonProcessingException {
        //商品数据
        QueryWrapper<Goods> goodQueryWrapper = new QueryWrapper<>();
        goodQueryWrapper.eq("published",1);
        goodQueryWrapper.orderBy(true,isAsc,orderBy);
        List<Goods> goods = goodsMapper.selectList(goodQueryWrapper);
        JSONArray array = new JSONArray();

        for (Goods good:goods) {
            JSONObject object = JSONObject.fromObject(good);
            //类别中间类
            QueryWrapper<Kind2goods> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("right_id",good.getId());
            Kind2goods kind2goods = kind2goodsMapper.selectOne(queryWrapper);
            if (kind2goods!=null) {
                String id = kind2goods.getLeftId();
                Kinds kind = kindsMapper.selectById(id);
                object.put("kindName", kind.getName());
            }

            //评论中间类
            QueryWrapper<Good2comment> commentQueryWrapper = new QueryWrapper<>();
            commentQueryWrapper.eq("left_id",good.getId());
            List<Good2comment> good2commentList = good2commentMapper.selectList(commentQueryWrapper);
            List<String> leftIdListCommon = new ArrayList<>();
            for (Good2comment good2comment: good2commentList ) {
                leftIdListCommon.add(good2comment.getRightId());
            }

            //评论数据
            if (leftIdListCommon.size()>0) {
                QueryWrapper<Comment> commentQueryWrapper1 = new QueryWrapper<>();
                commentQueryWrapper1.in("id", leftIdListCommon);
                List<Comment> commentList = commentMapper.selectList(commentQueryWrapper1);
                object.put("comments", commentList);
            }
            if (good.getModifyTime()!=null) {
                DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                String localTime = df.format(good.getModifyTime());
                object.put("modifyTime", localTime);
            }
            array.add(object);
        }

        return  array;
    }
}
