package com.cooperation.onlineshop.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cooperation.onlineshop.entity.User;
import com.cooperation.onlineshop.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import static com.cooperation.onlineshop.common.UuidUtil.getShortUuid;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author CQRenMin
 * @since 2020-05-17
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    UserService userService;

    /**
     * 新增用户
     */
    @PostMapping("/add")
    public String addUser(HttpServletRequest request){
        String res="";
        try {
            User user = new User();
            user.setId(getShortUuid());
            user.setUsername(request.getParameter("username"));
            user.setPassword(request.getParameter("password"));
            String level = request.getParameter("level");
            user.setLevel(level == null ? 0 : Integer.parseInt(level));
            user.setPhone(request.getParameter("phone"));
            boolean save = userService.save(user);

            if (save) {
                res = "success";
            }
        } catch (Exception e){
            return e.getMessage();
        }
        return res;
    }

    /**
     * 删除用户
     */
    @DeleteMapping("/{id}")
    public String delUser(@PathVariable("id") String id){
        String res="";
        try {
            UpdateWrapper<User> updateWrapper= new UpdateWrapper<>();
            updateWrapper.eq("id",id);
            boolean remove = userService.remove(updateWrapper);
            if (remove) {
                res = "success";
            }
        } catch (Exception e){
            return e.getMessage();
        }
        return res;
    }

    /**
     * 修改用户
     */
    @PutMapping("/update")
    public String updateUser(HttpServletRequest request){
        String res="";
        try {
            User user = new User();
            UpdateWrapper<User> updateWrapper= new UpdateWrapper<>();
            if (request.getParameter("id")!=null){
                user.setId(request.getParameter("id"));
                if (request.getParameter("password")!=null){
                    user.setId(request.getParameter("password"));
                }
                if (request.getParameter("phone")!=null){
                    user.setId(request.getParameter("phone"));
                }
                if (request.getParameter("username")!=null){
                    user.setId(request.getParameter("username"));
                }
            }
            updateWrapper.setEntity(user);
            boolean save = userService.update(updateWrapper);
            if (save) {
                res = "success";
            }
        } catch (Exception e){
            return e.getMessage();
        }
        return res;
    }

    /**
     * 获取单个用户信息
     */
    @GetMapping("/{id}")
    public User getUserById(@PathVariable("id") String id) throws Exception{
        QueryWrapper<User> userQueryWrapper= new QueryWrapper<>();
        userQueryWrapper.eq("id",id);
        return userService.getOne(userQueryWrapper);
    }

    /**
     * 获取所有的用户信息--分页
     */
    @GetMapping("/getAll")
    public Object getAll(HttpServletRequest request){
        //获取前台发送过来的数据
        int pageIndex = Integer.parseInt(request.getParameter("pageIndex")==null?"1":request.getParameter("pageIndex"));
        int pageSize = Integer.parseInt(request.getParameter("pageSize")==null?"10":request.getParameter("pageSize"));
        String orderBy=request.getParameter("orderBy")==null?"level":request.getParameter("orderBy");
        String ascDesc=request.getParameter("ascDesc")==null?"asc":"desc";
        IPage<User> page = new Page<>(pageIndex, pageSize);
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.setEntity(new User());
        if ("asc".equals(ascDesc)){
            wrapper.orderByDesc(orderBy);
        }else{
            wrapper.orderByAsc(orderBy);
        }
        return userService.page(page, wrapper);
    }
}
