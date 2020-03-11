package edu.niit.props;

/**
 * Application类的单元测试务必与Application类在同一个包下，否则会出现Bean不能自动装配的问题
 * 使用以下注解可以解决PropsDemoApplication类与测试类不在同一个包下
 * @SpringBootTest(classes = PropsDemoApplication.class)
 * 或
 * @SpringBootTest
 * @ContextConfiguration(classes = PropsDemoApplication.class)
 */
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PropsDemoApplicationTests {

    @Test
    void contextLoads() {
    }

}
