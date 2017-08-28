package com.basicframe.system.mapper;


import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.basicframe.system.entity.User;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.Map;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author lilihao
 * @since 2017-08-14
 */
@Repository
public interface UserMapper extends BaseMapper<User> {
}