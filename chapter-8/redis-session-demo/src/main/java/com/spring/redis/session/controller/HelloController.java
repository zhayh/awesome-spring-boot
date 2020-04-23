package com.spring.redis.session.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.UUID;

/**
 * @author : zhayh
 * @date : 2020-4-19 08:34
 * @description :
 */

@RestController
public class HelloController {
    @Value("${server.port}")
    Integer port;

    @GetMapping("/set")
    public String set(HttpServletRequest request) {
        String userId = UUID.randomUUID().toString().replaceAll("-", "");
        request.getSession().setAttribute("userId", userId);
        return "Session 设置成功.<br />userId：" + userId;
    }

    @GetMapping("/get")
    public String get(HttpServletRequest request) {
        HttpSession session = request.getSession();
        int port = request.getLocalPort();
        String sessionId = session.getId();
        String userId = request.getSession().getAttribute("userId").toString();
        return "端口：" + port + "<br/>sessionId：" + sessionId + "<br/>属性userId：" + userId;
    }
}
