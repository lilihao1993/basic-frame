package com.example.demo.web;

import com.basicframe.BasicframeApplication;
import com.basicframe.demo.web.UserController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

/**
 * Created by Administrator on 2017/8/9.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = BasicframeApplication.class)
public class UserControllerTest {

    @Autowired
    private UserController userController;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
    }

    /**
     * 描述：测试Demo
     *
     * @throws Exception
     */
    @Test
//    @Ignore
    public void testDemo() throws Exception {
        ResultActions ra = mockMvc.
                perform(MockMvcRequestBuilders.get("/demo/user/list"));
        MvcResult mr = ra.andReturn();
        System.out.println("==============================");
        System.out.println(mr.getResponse().getContentAsString());
    }

}
