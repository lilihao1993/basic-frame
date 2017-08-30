/*
 *  Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
 */
package com.basicframe.system.web;

import com.basicframe.common.constant.Constant;
import com.basicframe.common.remote.ajax.AjaxResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpSession;

/**
 * 描述: 系统管理首页控制器 .<br>
 *
 * @author xiajunwei
 * @date 2016年3月15日
 */
@Controller
@RequestMapping
@SessionAttributes(Constant.SESSION_USER_INFO)
public class IndexController {
    private static Logger logger = LoggerFactory.getLogger(IndexController.class);

    /**
     * 进入登录页面
     *
     * @return 登录页面
     * @throws Exception
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String login(Model model) throws Exception {
        model.addAttribute("ref", "client");
        return "login";
    }

    /**
     * 进入管理首页
     *
     * @return 管理首页
     * @throws Exception
     */
    @RequestMapping(value = "/admin/index", method = RequestMethod.GET)
    public String index() throws Exception {
        return "index";
    }

    /**
     * 切换账户/退出
     *
     * @param session       会话
     * @param sessionStatus 会话状态
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/admin/cat_user", method = RequestMethod.GET)
    public String catUser(HttpSession session, SessionStatus sessionStatus) throws Exception {
        // 1.删除session中数据
        sessionStatus.setComplete();
        session.invalidate();
        return "login";
    }
}
