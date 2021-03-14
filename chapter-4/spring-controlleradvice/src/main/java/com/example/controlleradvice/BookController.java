package com.example.controlleradvice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : zhayh
 * @date : 2021-3-4 14:03
 * @description :
 */

@RestController
public class BookController {
    @GetMapping("/book")
    public String book(@ModelAttribute("book") Book book,
                       @ModelAttribute("author") Author author) {
        return book.toString() + ">>>" + author.toString();
    }
}


// http://localhost:8080/book?b.name=三国演义&b.price=69.9&a.name=罗贯中&a.age=85
