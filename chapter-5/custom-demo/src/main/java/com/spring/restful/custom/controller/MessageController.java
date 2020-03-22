package com.spring.restful.custom.controller;

import com.spring.restful.custom.pojo.Message;
import com.spring.restful.custom.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    private MessageService messageService;

    @GetMapping("/message")
    public ResponseEntity<List<Message>> list() {
        List<Message> list = this.messageService.findAll();
        if (!list.isEmpty()) {
            return ResponseEntity.ok(list);
        } else {
            return ResponseEntity.noContent().build();
        }

    }

    @PostMapping("/message")
    public ResponseEntity<Message> create(@RequestBody Message message) {
        Message msg = this.messageService.save(message);
        return ResponseEntity.ok(msg);
    }

    @PutMapping("/message")
    public ResponseEntity<Message> modify(@RequestBody Message message) {
        Message msg = this.messageService.update(message);
        return ResponseEntity.ok(msg);
    }

    @PatchMapping("/message/text")
    public ResponseEntity<Message> patch(@RequestBody Message message) {
        Message msg = this.messageService.updateText(message);
        return ResponseEntity.ok(msg);
    }

    @GetMapping("/message/{id}")
    public ResponseEntity<Message> get(@PathVariable Long id) {
        Message msg = this.messageService.findOne(id);
        return ResponseEntity.ok(msg);
    }

    @DeleteMapping("/message/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id) {
        this.messageService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
