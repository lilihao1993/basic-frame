package com.basicframe.system.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.basicframe.common.utils.EncryptUtils;
import com.basicframe.common.utils.StringUtils;
import com.basicframe.system.entity.User;
import com.basicframe.system.enums.EUser;
import com.basicframe.system.mapper.UserMapper;
import com.basicframe.system.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

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
    @Autowired
    private UserMapper userMapper;

    /**
     * 描述：根据用户名获取用户
     *
     * @param userName 用户名
     * @return
     * @throws Exception
     */
    @Override
    public User getByUserName(String userName) throws Exception {
        //1.获取用户
        User user = new User();
        user.setUserName(userName);
        return userMapper.selectOne(user);
    }

//    /**
//     * 描述：分页获取用户列表
//     *
//     * @param request 分页响应
//     * @return
//     * @throws Exception
//     */
//    @Override
//    public List<User> pageUsers(PageRequest request) throws Exception {
//        //1.获取用户列表
//        PageHelper.startPage(request.getPageNum(), request.getLength());
//        return userMapper.selectByMap(request.getParams());
//    }

    /**
     * 描述：编辑用户
     *
     * @param user 用户对象
     * @throws Exception
     */
    @Override
    public void editUser(User user) throws Exception {
        //1.设置密码哈希值
        user.setEncryptSalt(EncryptUtils.md5Encoder(user.getPassword()));

        //2.设置密码加密后的值
        user.setPassword(EncryptUtils.encryptPassword(user.getPassword(), user.getEncryptSalt()));

        //3.如果id为空，则是新增操作，否则为修改操作
        user.setOperateTime(new Date());
        if (StringUtils.isBlank(user.getId())) {
            //4.设置用户初始值
            user.setStatus(EUser.STATUS_NORMAL.getValue());
            user.setCreateTime(new Date());
            userMapper.insert(user);
        } else {
            userMapper.updateById(user);
        }
    }
}
