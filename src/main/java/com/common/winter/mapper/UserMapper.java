package com.common.winter.mapper;

import com.common.winter.vo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    public User readUser(String username);
    public List<String> readAuthority(String username);

}
