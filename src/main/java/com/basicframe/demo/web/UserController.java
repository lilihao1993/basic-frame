package com.basicframe.demo.web;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
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

    /**
     * 描述：获取用户列表
     *
     * @return 用户列表
     * @throws Exception
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<User> getList() throws Exception {
        return userService.selectByMap(new HashMap<>());
    }

    /**
     * 描述：分页获取用户列表
     *
     * @param pageNumer  页码
     * @param pageSize   页大小
     * @param queryParam 查询参数
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/page", method = RequestMethod.GET)
    public Page<User> readList(int pageNumer, int pageSize, String queryParam) throws Exception {
        EntityWrapper ew = new EntityWrapper();
        ew.setEntity(new User());
        ew.eq("SEX", queryParam);
        return userService.selectPage(new Page<>(pageNumer, pageSize), ew);
    }

}
