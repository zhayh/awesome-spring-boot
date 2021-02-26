package edu.niit.props.controller;

import edu.niit.props.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : zhayh
 * @date : 2020-2-28 17:15
 * @description :
 */

@RestController
public class BookController {
    @Autowired
    private Book book;

    @GetMapping("/book")
    public String book() {
        return book.toString();
    }
}
