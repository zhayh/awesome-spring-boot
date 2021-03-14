package com.example.cors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : zhayh
 * @date : 2021-3-5 15:03
 * @description :
 */

//@CrossOrigin(origins = "http://localhost:8081", maxAge = 3600)
@RestController
public class DemoController {
    @GetMapping("/hello")
    public String index() {
        return "Hello World";
    }
}
