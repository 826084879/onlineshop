package com.cooperation.onlineshop.mapper;

import com.cooperation.onlineshop.entity.Files;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

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
public interface FilesMapper extends BaseMapper<Files> {

    List<String> getDelFiles();
    List<Map<String,Object>> getBannerImgs();
}
