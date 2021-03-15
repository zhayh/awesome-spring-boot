package com.example.spring.props.controller;

import com.example.spring.props.vo.Book;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author : zhayh
 * @date : 2020-2-28 17:15
 * @description :
 */

@RestController
public class BookController {
    @Resource
    private Book book;

    @GetMapping("/book")
    public String book() {
        return book.toString();
    }
}
