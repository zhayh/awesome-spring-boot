package com.spring.restful.custom.controller;

import com.spring.restful.custom.common.ExceptionType;
import com.spring.restful.custom.exception.CustomException;
import com.spring.restful.custom.pojo.Message;
import com.spring.restful.custom.service.MessageService;
import io.swagger.annotations.*;
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
@Api(tags = {"消息 API"}, protocols = "http")
@SwaggerDefinition(tags = {
        @Tag(name="消息 API", description = "消息管理的API接口")
})
public class MessageController {
    @Autowired
    private MessageService messageService;

    @GetMapping("/message")
    @ApiOperation(value = "消息列表",
            notes = "完整的消息内容列表",
            produces = "application/json, application/xml")
    public ResponseEntity<List<Message>> list() {
        List<Message> list = this.messageService.findAll();
        if (!list.isEmpty()) {
            return ResponseEntity.ok(list);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @PostMapping("/message")
    @ApiOperation(value = "添加消息", notes = "根据参数创建消息")
    public ResponseEntity<Message> create(@RequestBody Message message) {
        if (message == null || message.getText() == null || message.getText().isEmpty()) {
            throw new CustomException(ExceptionType.USER_INPUT_ERROR);
        }
        try {
            Message msg = this.messageService.save(message);
            return ResponseEntity.ok(msg);
        } catch (Exception e) {
            e.printStackTrace();
            throw new CustomException(ExceptionType.SERVER_ERROR.getCode(), e.getMessage());
        }
    }

    @PutMapping("/message")
    @ApiOperation(value = "修改消息", notes = "根据参数修改消息")
    @ApiResponses({
            @ApiResponse(code = 100, message = "请求参数有误"),
            @ApiResponse(code = 101, message = "未授权"),
            @ApiResponse(code = 102, message = "禁止访问"),
            @ApiResponse(code = 103, message = "请求路径不存在"),
            @ApiResponse(code = 104, message = "服务器内部错误"),
            @ApiResponse(code = 200, message = "成功")
    })
    public ResponseEntity<Message> modify(@RequestBody Message message) {
        if (message == null || message.getText() == null || message.getText().isEmpty()) {
            throw new CustomException(ExceptionType.USER_INPUT_ERROR);
        }
        try {
            Message msg = this.messageService.update(message);
            return ResponseEntity.ok(msg);
        } catch (Exception e) {
            e.printStackTrace();
            throw new CustomException(ExceptionType.SERVER_ERROR.getCode(), e.getMessage());
        }
    }

    @ApiOperation(value = "修改消息内容", notes = "根据参数修改消息内容")
    @PatchMapping("/message/text")
    public ResponseEntity<Message> patch(@RequestBody Message message) {
        if (message == null || message.getText() == null || message.getText().isEmpty()) {
            throw new CustomException(ExceptionType.USER_INPUT_ERROR);
        }
        try {
            Message msg = this.messageService.updateText(message);
            return ResponseEntity.ok(msg);
        } catch (Exception e) {
            e.printStackTrace();
            throw new CustomException(ExceptionType.SERVER_ERROR.getCode(), e.getMessage());
        }
    }

    @ApiOperation(value = "获取消息", notes = "根据id获取消息")
    @GetMapping("/message/{id}")
    public ResponseEntity<Message> get(@PathVariable("id") Long id) {
        Message msg = this.messageService.findOne(id);
        if (msg != null) {
            return ResponseEntity.ok(msg);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @ApiOperation(value = "删除消息", notes = "根据id删除消息")
//    @ApiImplicitParams({@ApiImplicitParam(name = "id", value = "1", required = true,
//            dataType = "Long", paramType = "path")})
    @DeleteMapping("/message/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id) {
        this.messageService.delete(id);
        return ResponseEntity.noContent().build();
    }
}

