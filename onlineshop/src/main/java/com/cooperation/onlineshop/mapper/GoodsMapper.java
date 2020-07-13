package com.cooperation.onlineshop.mapper;

import com.cooperation.onlineshop.entity.Goods;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author CQRenMin
 * @since 2020-05-23
 */
public interface GoodsMapper extends BaseMapper<Goods> {
    List<Map<String,Object>> getDetailGoodsMsg(Map<String,Object> map);
    List<Map<String,Object>> getGoodByName(String name);
    Map<String,Object> getGoodById(String id);
}
