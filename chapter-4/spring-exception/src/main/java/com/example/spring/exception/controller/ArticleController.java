package com.example.spring.exception.controller;

import com.example.spring.exception.ResponseResult;
import com.example.spring.exception.service.ExceptionService;
import com.example.spring.exception.vo.Article;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * @author : zhayh
 * @date : 2021-3-14 11:14
 * @description : 测试自定义异常处理的controller类
 */

@Slf4j
@RestController
@RequestMapping("/api")
public class ArticleController {
    @Resource
    private ExceptionService exceptionService;

    @GetMapping("/articles/{id}")
    public ResponseResult getArticle(@PathVariable("id") Long id) {
        if (id == 1) {
            exceptionService.systemBizError();
        } else {
            exceptionService.userBizError(-1);
        }
        return ResponseResult.success();
    }

    @PostMapping("/articles")
    public ResponseResult save(@Valid @RequestBody Article article) {
        log.info("save: " + article);
        return ResponseResult.success();
    }

    // 更新一篇Article，使用PUT方法，以id为主键更新
    @PutMapping("/articles")
    public ResponseResult updateArticle(@RequestBody Article article) {
        if (article.getId() == null) {
            // article.id是必传参数，因为通常根据id去修改数据
            // TODO 抛出一个自定义的异常
            exceptionService.userBizError(-1);
        }
        log.info("updateArticle: " + article);
        return ResponseResult.success();
    }

    // 删除一篇Article，使用DELETE方法，参数为id
    @DeleteMapping("/articles/{id}")
    public ResponseResult deleteArticle(@PathVariable("id") Long id) {
        log.info("deleteArticle: " + id);
        return ResponseResult.success();
    }
}
