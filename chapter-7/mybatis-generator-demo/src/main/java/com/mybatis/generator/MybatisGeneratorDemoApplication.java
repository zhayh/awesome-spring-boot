package com.mybatis.generator;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@SpringBootApplication
@MapperScan("com.mybatis.generator.mapper")
public class MybatisGeneratorDemoApplication implements ApplicationRunner {
//    @Resource
//    private MessageMapper messageMapper;

    public static void main(String[] args) {
        SpringApplication.run(MybatisGeneratorDemoApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        // 生成
//        generateArtifacts();
        // 测试
//        playWithArtifacts();
    }

    private void generateArtifacts() throws Exception {
        List<String> warnings = new ArrayList<>();
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(
                this.getClass().getResourceAsStream("/mybatis-generator-config.xml"));
        DefaultShellCallback callback = new DefaultShellCallback(true);
        MyBatisGenerator generator = new MyBatisGenerator(config, callback, warnings);
        generator.generate(null);
    }

    private void playWithArtifacts() {
//        Message msg1 = new Message().withMsgText("espresso")
//                .withMsgSummary("coffee");
//        messageMapper.insert(msg1);
//
//        Message msg2 = new Message().withMsgText("latte")
//                .withMsgSummary("coffee");
//        messageMapper.insert(msg2);
//
//        Message msg = messageMapper.selectByPrimaryKey(1);
//        log.info("Message {}", msg);
//
//        MessageExample example = new MessageExample();
//        example.createCriteria().andMsgSummaryEqualTo("coffee");
//        List<Message> msgs = messageMapper.selectByExample(example);
//        msgs.forEach(c -> log.info("selectByExample: {}", c));
    }
}
