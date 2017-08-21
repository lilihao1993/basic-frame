package com.basicframe.common.Interceptor;

import com.basicframe.common.constant.Constant;
import com.basicframe.common.utils.HttpUtils;
import com.basicframe.system.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Administrator on 2017/8/21.
 */
public class MyInterceptor implements HandlerInterceptor {

    /**
     * 日志
     */
    Logger logger = LoggerFactory.getLogger(MyInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        User user = (User) httpServletRequest.getSession().getAttribute(Constant.SESSION_USER_INFO);
        //判断用户ID是否存在，不存在就跳转到登录界面
        if (user == null) {
            if (HttpUtils.isAjax(httpServletRequest)) {
                HttpUtils.writeError(httpServletResponse, Constant.LOGIN_ERROR_INFO, HttpStatus.UNAUTHORIZED.value());
            } else {
                // 未登录
                httpServletResponse.sendRedirect("/");
            }
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
