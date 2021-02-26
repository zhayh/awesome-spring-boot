package com.example.lombok;

import com.example.lombok.model.Person;
import com.example.lombok.model.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class LombokDemoApplication implements CommandLineRunner {
    Person person;

    public static void main(String[] args) {
        SpringApplication.run(LombokDemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        person.setName("niit");
        person.setAge(20);

        log.info(person.toString());

        Student student = Student.builder().StuNo("190231001").name("张晓").build();
        log.info(student.toString());

    }

}
