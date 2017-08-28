package com.basicframe.system.web;

import com.basicframe.common.constant.Constant;
import com.basicframe.common.remote.ajax.AjaxResult;
import com.basicframe.common.utils.EncryptUtils;
import com.basicframe.system.entity.User;
import com.basicframe.system.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@SessionAttributes(Constant.SESSION_USER_INFO)
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
    @ResponseBody
    public AjaxResult login(String userName, String password, Model model) throws Exception {
        //1.根据用户名获取用户
        User user = userService.getByUserName(userName);

        //2.如果用户不为空，则验证密码是否正确
        if (user != null) {

            //3.获取密码哈希值
            String passwordMD5 = EncryptUtils.encryptPassword(password, user.getEncryptSalt());

            //4.如果哈希值正确，则表示验证成功，将其加入到session中,返回成功
            if (passwordMD5.equals(user.getPassword())) {

                //5.将其用户放入session
                model.addAttribute(Constant.SESSION_USER_INFO, user);
                return AjaxResult.success("验证成功！");
            }
        }
        return AjaxResult.error("验证是失败！");
    }
}
