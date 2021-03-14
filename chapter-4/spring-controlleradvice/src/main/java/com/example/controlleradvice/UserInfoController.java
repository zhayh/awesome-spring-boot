package com.example.controlleradvice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author : zhayh
 * @date : 2021-3-4 11:43
 * @description :
 */

@Slf4j
@RestController
public class UserInfoController {
    @GetMapping("/userInfo")
    public String hello(Model model) {
        StringBuilder result = new StringBuilder();
        Map<String, Object> map = model.asMap();
        for(String key : map.keySet()) {
            result.append(key).append(": ").append(map.get(key));
        }
        log.info(result.toString());
        return result.toString();
    }
}
