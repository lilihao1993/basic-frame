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
     * 描述：是否登录成功
     *
     * @param userName 用户名
     * @param password 密码
     * @return true：登录成功  false：登录失败
     * @throws Exception
     */
    boolean isLoginSuccess(String userName, String password) throws Exception;
}
