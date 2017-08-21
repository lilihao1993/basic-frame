package com.basicframe.system.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.basicframe.system.entity.User;
import com.basicframe.system.mapper.UserMapper;
import com.basicframe.system.service.IUserService;
import org.springframework.stereotype.Service;

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
	
}
