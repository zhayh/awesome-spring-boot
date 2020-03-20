package com.spring.restful.controller;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

/**
 * @author : zhayh
 * @date : 2020-2-18 09:45
 * @description : MessageController的测试类
 */
@SpringBootTest
@Slf4j
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MessageControllerTest {
    @Autowired
    private MessageController controller;
    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() throws Exception {
        this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    @Order(1)
    public void saveMessage() throws Exception {
        //  // 初始化数据
        for (int i = 1; i < 10; i++) {
            final MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
            params.add("text", "text" + i);
            params.add("summary", "summary" + i);
            mockMvc.perform(MockMvcRequestBuilders
                    .post("/message").params(params))
                    .andReturn();
        }
        // MultiValueMap: 存储需要发送的请求参数
        final MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("text", "text");
        params.add("summary", "summary");
        mockMvc.perform(MockMvcRequestBuilders.post("/message").params(params))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content()
                        .string("{\"id\":10,\"text\":\"text\",\"summary\":\"summary\"}"));
    }

    /**
     * 获取所有数据
     */
    @Test
    @Order(2)
    public void getAllMessage() throws Exception {
        String result = mockMvc.perform(MockMvcRequestBuilders.get("/message"))
                .andReturn().getResponse().getContentAsString();
        log.info("Get Result: {}", result);
    }

    /**
     * 获取一条数据
     */
    @Test
    @Order(3)
    public void getOneMessage() throws Exception {
//        mockMvc.perform(MockMvcRequestBuilders.get("/message/5"))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.content()
//                        .string("{\"id\":5,\"text\":\"text5\",\"summary\":\"summary5\"}"));
        String result = mockMvc.perform(MockMvcRequestBuilders.get("/message/5"))
                .andReturn().getResponse().getContentAsString();
        log.info("第5个message: {}", result);
    }

    /**
     * 修改一条数据
     */
    @Test
    @Order(4)
    public void modifyMessage() throws Exception {
        final MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("id", "4");
        params.add("text", "text");
        params.add("summary", "summary");
        mockMvc.perform(MockMvcRequestBuilders.put("/message").params(params))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content()
                        .string("{\"id\":4,\"text\":\"text\",\"summary\":\"summary\"}"));
    }
    /**
     * 局部修改一条记录
     */
    @Test
    @Order(5)
    public void patchMessage() throws Exception {
        final MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("id", "6");
        params.add("text", "text");
        mockMvc.perform(MockMvcRequestBuilders.patch("/message/text").params(params))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content()
                        .string("{\"id\":6,\"text\":\"text\",\"summary\":\"summary6\"}"));
    }
    /**
     * 删除一条记录
     */
    @Test
    @Order(6)
    public void deleteMessage() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/message/6"))
                .andReturn();
        String mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/message"))
                .andReturn().getResponse().getContentAsString();
        log.info("After delete: {}", mvcResult);
    }
}
