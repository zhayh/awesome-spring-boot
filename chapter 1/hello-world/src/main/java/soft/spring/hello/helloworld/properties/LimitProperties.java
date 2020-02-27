package soft.spring.hello.helloworld.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * @author : zhayh
 * @date : 2020-2-8 21:43
 * @description :
 */

@Data
@Component
@ConfigurationProperties(prefix = "limit")
public class LimitProperties {
    private BigDecimal minMoney;
    private BigDecimal maxMoney;
    private String description;
}
