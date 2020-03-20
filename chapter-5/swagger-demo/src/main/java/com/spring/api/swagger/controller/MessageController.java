package com.spring.restful.controller;

import com.spring.restful.pojo.Message;
import com.spring.restful.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author : zhayh
 * @date : 2020-2-18 09:18
 * @description : 控制器
 */
@RestController
public class MessageController {
    @Autowired
    private MessageRepository repository;

    @GetMapping("/message")
    public List<Message> list() {
        return this.repository.findAll();
    }

    @PostMapping("/message")
    public Message create(Message message) {
        return this.repository.save(message);
    }

    @PutMapping("/message")
    public Message modify(Message message) {
        return this.repository.update(message);
    }

    @PatchMapping("/message/text")
    public Message patch(Message message) {
        return this.repository.updateText(message);
    }

    @GetMapping("/message/{id}")
    public Message get(@PathVariable("id") Long id) {
        return this.repository.findOne(id);
    }

    @DeleteMapping("/message/{id}")
    public void delete(@PathVariable("id") Long id) {
        this.repository.delete(id);
    }
}
