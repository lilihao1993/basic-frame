/*
 *  Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
 */
package com.basicframe.system.web;

import com.basicframe.common.remote.ajax.AjaxResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 描述: 系统管理首页控制器 .<br>
 *
 * @author xiajunwei
 * @date 2016年3月15日
 */
@Controller
@RequestMapping
public class IndexController {
    private static Logger logger = LoggerFactory.getLogger(IndexController.class);

    /**
     * 进入登录页面
     *
     * @return 登录页面
     * @throws Exception
     */
    @RequestMapping(value = "/")
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
    @RequestMapping(value = "/admin/index")
    public String index() throws Exception {
        return "index";
    }
}
