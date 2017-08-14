package com.basicframe.demo.web;


import com.basicframe.demo.entity.User;
import com.basicframe.demo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author lilihao
 * @since 2017-08-14
 */
@RestController
@RequestMapping("/demo/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<User> getList() throws Exception {
        return userService.selectByMap(new HashMap<>());
    }

}
