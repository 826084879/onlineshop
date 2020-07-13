package com.cooperation.onlineshop.mapper;

import com.cooperation.onlineshop.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author CQRenMin
 * @since 2020-05-23
 */
public interface UserMapper extends BaseMapper<User> {
    User findByUserName(@Param("username") String username);
}
