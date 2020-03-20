package com.spring.api.swagger.controller;

import com.spring.api.swagger.pojo.Message;
import com.spring.api.swagger.repository.MessageRepository;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
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
    private MessageRepository repository;

    @GetMapping("/message")
    @ApiOperation(value = "消息列表",
            notes = "完整的消息内容列表",
            produces = "application/json, application/xml",
            consumes = "application/json, application/xml")
    public List<Message> list() {
        return this.repository.findAll();
    }

    @PostMapping("/message")
    @ApiOperation(value = "添加消息", notes = "根据参数创建消息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "消息 ID", required = true, dataType = "Long", paramType = "query"),
            @ApiImplicitParam(name = "text", value = "正文", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "summary", value = "摘要", dataType = "String", paramType = "query")})
    public Message create(Message message) {
        return this.repository.save(message);
    }

    @PutMapping("/message")
    @ApiOperation(value = "修改消息", notes = "根据参数修改消息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "消息 ID", required = true, dataType = "Long", paramType = "query"),
            @ApiImplicitParam(name = "text", value = "正文", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "summary", value = "摘要", dataType = "String", paramType = "query")})
    @ApiResponses({
            @ApiResponse(code = 100, message = "请求参数有误"),
            @ApiResponse(code = 101, message = "未授权"),
            @ApiResponse(code = 102, message = "禁止访问"),
            @ApiResponse(code = 103, message = "请求路径不存在"),
            @ApiResponse(code = 104, message = "服务器内部错误"),
            @ApiResponse(code = 200, message = "成功")
    })
    public Message modify(Message message) {
        return this.repository.update(message);
    }

    @ApiOperation(value = "修改消息内容", notes = "根据参数修改消息内容")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "消息 ID", required = true, dataType = "Long", paramType = "query"),
            @ApiImplicitParam(name = "text", value = "正文", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "summary", value = "摘要", dataType = "String", paramType = "query")})
    @PatchMapping("/message/text")
    public Message patch(Message message) {
        return this.repository.updateText(message);
    }

    @ApiOperation(value = "获取消息", notes = "根据id获取消息")
    @ApiImplicitParams({@ApiImplicitParam(name = "id", value = "消息 ID", required = true, dataType = "Long",
            paramType = "query")})
    @GetMapping("/message/{id}")
    public Message get(@PathVariable("id") Long id) {
        return this.repository.findOne(id);
    }

    @ApiOperation(value = "删除消息", notes = "根据id删除消息")
    @ApiImplicitParams({@ApiImplicitParam(name = "id", value = "消息 ID", required = true, dataType = "Long",
            paramType = "query")})
    @DeleteMapping("/message/{id}")
    public void delete(@PathVariable("id") Long id) {
        this.repository.delete(id);
    }
}

