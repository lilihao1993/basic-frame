package com.basicframe.demo.service.impl;

import com.basicframe.demo.entity.User;
import com.basicframe.demo.mapper.UserMapper;
import com.basicframe.demo.service.IUserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
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
