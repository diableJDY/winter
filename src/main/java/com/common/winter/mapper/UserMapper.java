package com.common.winter.mapper;

import com.common.winter.dto.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.security.core.GrantedAuthority;

import java.util.List;

@Mapper
public interface UserMapper {
    public User readUser(String username);

    public List<GrantedAuthority> readAuthority(String username);

    public void createUser(User user);

    public void createAuthority(User user);

    public void deleteUser(String username);

    public void deleteAuthority(String username);


}
