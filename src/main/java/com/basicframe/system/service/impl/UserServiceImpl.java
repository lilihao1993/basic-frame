package com.basicframe.system.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.basicframe.common.utils.EncryptUtils;
import com.basicframe.system.entity.User;
import com.basicframe.system.mapper.UserMapper;
import com.basicframe.system.service.IUserService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.constraints.NotNull;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author lilihao
 * @since 2017-08-14
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {


    /**
     * 描述：用户Mapper
     */
    private UserMapper userMapper;

    /**
     * 描述：是否登录成功
     *
     * @param userName 用户名
     * @param password 密码
     * @return
     * @throws Exception
     */
    @Override
    public boolean isLoginSuccess(String userName, String password) throws Exception {
        //1.获取用户
        User user = new User();
        user.setUserName(userName);
        user.setPassword(password);
        userMapper.selectOne(user);

        //2.若没有获取到用户，返回false
        if (user == null) {
            return false;
        }

        //3.获取密码哈希值
        String passwordMD5 = EncryptUtils.encryptPassword(user.getPassword(), user.getEncryptSalt());

        //4.如果哈希值正确，则返回true，否则返回false
        return passwordMD5.equals(user.getEncryptSalt());
    }
}
