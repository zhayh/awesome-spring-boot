package com.spring.data.datasource;

import com.spring.data.datasource.repository.MessageRepository;
import com.spring.data.datasource.repository.impl.MessageRepositoryImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@Slf4j
@SpringBootApplication
public class DatasourceDemoApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(DatasourceDemoApplication.class, args);
    }

    @Autowired
    private DataSource dataSource;

    @Autowired
    private MessageRepository messageRepository;

    @Override
    public void run(String... args) throws Exception {
        showConnection();
        showData();
    }

    public void showConnection() throws SQLException {
        log.info("datasource: {}", dataSource.toString());
        Connection connection = dataSource.getConnection();
        log.info("connection: {}", connection.toString());
        connection.close();
    }

    public void showData() {
        log.info("messages: {}", messageRepository.findAll().toString());
    }
}
