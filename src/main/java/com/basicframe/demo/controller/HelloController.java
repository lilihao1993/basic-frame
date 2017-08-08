package com.basicframe.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2017/8/7.
 */
@RestController
@RequestMapping("/hello")
public class HelloController {

    /**
     * 描述：跳转到 hello页
     *
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/page", method = RequestMethod.GET)
    public String page() throws Exception {
        return "HELLO WORLD";
    }
}
