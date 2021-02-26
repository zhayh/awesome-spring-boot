package edu.niit.props.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * @author : zhayh
 * @date : 2020-3-10 21:02
 * @description :
 */
@Slf4j
@Configuration
@Profile("prod")
public class ProdDBConnector implements DBConnector {
    @Override
    public void configure() {
        log.info("prod环境配置");
    }
}
