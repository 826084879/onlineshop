package com.cooperation.onlineshop.common;

import com.cooperation.onlineshop.entity.Role;
import com.cooperation.onlineshop.entity.User;
import com.cooperation.onlineshop.mapper.UserMapper;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collection;

public class CustomUserService implements UserDetailsService {

    @Resource
    UserMapper sysUserMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user=sysUserMapper.findByUserName(username);
        if (user == null) {
            throw new UsernameNotFoundException("用户不存在");
        }else{
            System.out.println("username: "+user.getUsername()+", password: "+user.getPassword());
            Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
            //用于添加用户的权限。只要把用户权限添加到authorities 就万事大吉。
            for(Role role:user.getRoles())
            {
                authorities.add(new SimpleGrantedAuthority(role.getName()));
            }
            return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorities);
        }

    }
}
