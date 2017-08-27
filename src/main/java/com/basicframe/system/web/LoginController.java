package com.basicframe.system.web;

import com.basicframe.common.remote.ajax.AjaxResult;
import com.basicframe.system.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

    /**
     * 用户服务注入
     */
    @Autowired
    private IUserService userService;

    /**
     * 描述：登录验证
     *
     * @param userName 用户名
     * @param password 密码
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public AjaxResult login(String userName, String password) throws Exception {
        //1.判断用户名与密码是否正确
        boolean flag = userService.isLoginSuccess(userName, password);

        //2.返回结果信息
        if (flag) {
            AjaxResult.success("验证成功！");
        }
        return AjaxResult.error("验证失败！");
    }

}
