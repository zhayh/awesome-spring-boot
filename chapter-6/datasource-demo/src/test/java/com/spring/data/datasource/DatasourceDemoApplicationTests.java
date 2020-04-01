package com.spring.data.datasource;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@Slf4j
@SpringBootTest
class DatasourceDemoApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    private DataSource dataSource;

    @Test
    public void connectionTest() throws SQLException {
        log.info("datasource: {}", dataSource.toString());
        Connection connection = dataSource.getConnection();
        log.info("connection: {}", connection.toString());
        connection.close();

    }
}
