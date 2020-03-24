package soft.spring.mvc.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import soft.spring.mvc.demo.model.Coffee;

/**
 * @author : zhayh
 * @date : 2020-2-15 22:13
 * @description :
 */

@RestController
@RequestMapping("/api")
public class MyRestController {
    @RequestMapping("/hello")
    public Coffee get() {
        return Coffee.create();
    }
}
