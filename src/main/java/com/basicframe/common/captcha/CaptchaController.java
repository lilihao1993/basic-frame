package com.basicframe.common.captcha;

import com.basicframe.common.remote.ajax.AjaxResult;
import com.basicframe.common.utils.JSONUtils;
import com.basicframe.common.utils.StringUtils;
import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;

@Controller
public class CaptchaController {

    Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private Producer captchaProducer;


    /**
     * 描述：生成验证码
     *
     * @param request  请求
     * @param response 响应
     * @return
     */
    @RequestMapping("/verify")
    public ModelAndView doGet(HttpServletRequest request, HttpServletResponse response) {
        response.setDateHeader("Expires", 0);
        response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
        response.addHeader("Cache-Control", "post-check=0, pre-check=0");
        response.setHeader("Pragma", "no-cache");
        response.setContentType("image/jpeg");
        String capText = captchaProducer.createText();
        BufferedImage bi = captchaProducer.createImage(capText);
        request.getSession().setAttribute(Constants.KAPTCHA_SESSION_KEY, capText);
        try {
            ServletOutputStream out = response.getOutputStream();
            log.debug("captchaProducer.createText：" + capText);
            ImageIO.write(bi, "jpg", out);
            out.flush();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 描述：验证验证码
     *
     * @param verify  用户输入的验证码
     * @param request 请求
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/verify/validate", method = RequestMethod.GET)
    @ResponseBody
    public AjaxResult validateVerifyCode(@RequestParam("verifyCode") String verify, HttpServletRequest request) throws Exception {
        if (validate(verify, request)) {
            return AjaxResult.success("验证成功！");
        } else {
            return AjaxResult.error("验证码错误,请刷新或重新输入！");
        }

    }

    /**
     * 描述:判断验证码是否正确
     *
     * @param verifyCode 输入的验证码
     * @param request    请求
     * @return false:验证失败 true：验证码正确
     */
    public static boolean validate(String verifyCode, HttpServletRequest request) {
        String text = (String) request.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY);
        if (StringUtils.isBlank(text))
            return false;
        return verifyCode.equals(text);
    }
}
