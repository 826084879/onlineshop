package com.cooperation.onlineshop.service;

import com.cooperation.onlineshop.entity.Goods;
import com.baomidou.mybatisplus.extension.service.IService;
import com.fasterxml.jackson.core.JsonProcessingException;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author CQRenMin
 * @since 2020-05-18
 */
public interface GoodsService extends IService<Goods> {

    String addGoods(Goods goods,String kindName);
    String updateGoods(Goods goods);
    String getDetailGoodsMsg(String orderBy,boolean asc);
    List<Map<String,Object>> getGoodByName(String name);
    String publishGoods(String goodsId);
    JSONArray getAllGoods(String orderBy,boolean isAsc) throws JsonProcessingException;
}
