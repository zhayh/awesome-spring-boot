package com.example.controlleradvice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author : zhayh
 * @date : 2021-3-4 14:03
 * @description :
 */

@Slf4j
@RestController
public class TestController {
    @GetMapping("/exception")
    public String get()  {
        throw new RuntimeException("发生异常");
    }

    @GetMapping("/book")
    public String book(@ModelAttribute("book") Book book,
                       @ModelAttribute("author") Author author) {
        String result = book.toString() + ">>>" + author.toString();

        log.info(result);
        return result;
    }

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


// http://localhost:8080/book?b.name=三国演义&b.price=69.9&a.name=罗贯中&a.age=85
