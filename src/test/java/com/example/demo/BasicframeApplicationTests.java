package com.example.demo;

import com.basicframe.BasicframeApplication;
import com.basicframe.demo.controller.HelloController;
import org.junit.Before;
import org.junit.Ignore;
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

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = BasicframeApplication.class)
public class BasicframeApplicationTests {

    @Autowired
    private HelloController helloController;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(helloController).build();
    }

    /**
     * 描述：测试Demo
     *
     * @throws Exception
     */
    @Test
    @Ignore
    public void testDemo() throws Exception {
        ResultActions ra = mockMvc.
                perform(MockMvcRequestBuilders.get("/hello/page"));
        MvcResult mr = ra.andReturn();
        System.out.println("==============================");
        System.out.println(mr.getResponse().getContentAsString());
    }

}
