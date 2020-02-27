package soft.spring.hello.helloworld;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import soft.spring.hello.helloworld.controller.MySpringBootController;

/**
 * @author : zhayh
 * @date : 2020-2-16 08:40
 * @description :
 */

// 导入Spring测试框架
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class MySpringBootControllerTest {
    @Autowired
    private MySpringBootController controller;
    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }
    @Test
    public void testHello() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .get("/api/hello")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content()
                        .string("Hello, Spring Boot!"));
    }
}
//// 导入Spring测试框架
//@ExtendWith(SpringExtension.class)
//// 测试Web请求
//@WebMvcTest(MySpringBootController.class)
//public class HelloTest {
//    @Autowired
//    private MockMvc mockMvc;
//
//    @Test
//    public void testHello() throws Exception {
//        mockMvc.perform(MockMvcRequestBuilders
//                .get("/api/hello")
//                .accept(MediaType.APPLICATION_JSON))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.content()
//                        .string("Hello, Spring Boot!"));
//    }
//}
