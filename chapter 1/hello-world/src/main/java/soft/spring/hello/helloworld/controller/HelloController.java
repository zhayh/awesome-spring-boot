package soft.spring.hello.helloworld.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import soft.spring.hello.helloworld.properties.LimitProperties;

import java.math.BigDecimal;

/**
 * @author : zhayh
 * @date : 2020-2-8 21:38
 * @description :
 */

@RestController
@RequestMapping("/api")
public class HelloController {
    @Autowired
    private LimitProperties limitConfig;

    @Value("${limit.minMoney}")
    private BigDecimal minMoney;

    @GetMapping({"/say", "/hi"})
    public String say() {
        return "说明: " + limitConfig.getDescription() + "最少：" + minMoney;
    }

    @GetMapping("/say1/{id}")
    public String say(@PathVariable("id") String myId) {
        return "id: " + myId;
    }

    @PostMapping("/say2")
    public String say(@RequestParam(value = "id", required = false, defaultValue = "0") Integer myId) {
        return "id: " + myId;
    }
}
