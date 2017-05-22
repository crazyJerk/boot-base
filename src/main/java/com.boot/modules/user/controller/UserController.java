package com.boot.modules.user.controller;

import com.boot.modules.user.entity.User;
import com.boot.modules.user.service.UserService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by lisu on 2017/5/18.
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("allUser")
    public PageInfo<User> allUser(User user) {
        return userService.getAllUser(user);
    }
}
