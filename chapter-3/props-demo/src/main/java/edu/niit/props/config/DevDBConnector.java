package edu.niit.props.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * @author : zhayh
 * @date : 2020-3-10 21:01
 * @description :
 */
@Slf4j
@Configuration
@Profile("dev")
public class DevDBConnector implements DBConnector {
    @Override
    public void configure() {
        log.info("dev环境配置");
    }
}
