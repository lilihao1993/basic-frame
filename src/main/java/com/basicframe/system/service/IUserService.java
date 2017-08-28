package com.basicframe.system.service;


import com.baomidou.mybatisplus.service.IService;
import com.basicframe.system.entity.User;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author lilihao
 * @since 2017-08-14
 */
public interface IUserService extends IService<User> {

    /**
     * 描述：根据用户名获取用户
     *
     * @param userName 用户名
     * @throws Exception
     */
    User getByUserName(String userName) throws Exception;
}
