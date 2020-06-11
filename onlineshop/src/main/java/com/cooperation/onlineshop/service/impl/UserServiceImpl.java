package com.cooperation.onlineshop.service.impl;

import com.cooperation.onlineshop.entity.User;
import com.cooperation.onlineshop.mapper.UserMapper;
import com.cooperation.onlineshop.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author CQRenMin
 * @since 2020-05-23
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
