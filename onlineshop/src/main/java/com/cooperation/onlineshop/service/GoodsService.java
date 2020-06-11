package com.cooperation.onlineshop.service;

import com.cooperation.onlineshop.entity.Goods;
import com.baomidou.mybatisplus.extension.service.IService;
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

    String addGoods(Goods goods, MultipartFile[] files, JSONArray object);
    String updateGoods(Goods goods, MultipartFile[] files, JSONArray object);
    String getDetailGoodsMsg(String orderBy,boolean asc);
    List<Map<String,Object>> getGoodByName(String name);

    JSONArray getAllGoods(String orderBy,boolean isAsc);
}
