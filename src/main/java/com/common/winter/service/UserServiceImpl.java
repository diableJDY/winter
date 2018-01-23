package com.common.winter.service;

import com.common.winter.mapper.UserMapper;
import com.common.winter.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserMapper userMapper;



    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userMapper.readUser(username);
        user.setAuthorities(getAuthorities(username));
        return user;
    }




    @Override
    public Collection<GrantedAuthority> getAuthorities(String username) {
        List<String> string_authorities = userMapper.readAuthority(username);
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        for (String authority : string_authorities) {
            authorities.add(new SimpleGrantedAuthority(authority));
        }
        return authorities;

    }
}
