package com.boot.modules.user.service;

import com.boot.modules.user.entity.User;
import com.boot.modules.user.mapper.UserMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lisu on 2017/5/18.
 */
@Service
public class UserService {
    @Autowired
    private UserMapper mapper;

    public PageInfo<User> getAllUser(User user) {
        if (user.getPage() != null && user.getSize() != null) {
            PageHelper.startPage(user.getPage(), user.getSize());
        }
        return new PageInfo<User>(mapper.selectAll());
    }
}
