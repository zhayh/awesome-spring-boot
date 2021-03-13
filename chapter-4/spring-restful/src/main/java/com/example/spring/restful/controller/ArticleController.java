package com.example.spring.restful.controller;

import com.example.spring.restful.model.Article;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * @author : zhayh
 * @date : 2021-2-27 21:15
 * @description :
 */

@Slf4j
@RestController
@RequestMapping("/rest")
public class ArticleController {
    // 获取一篇Article，使用GET方法,根据id查询
    // @RequestMapping(value = "/articles/{id}", method = RequestMethod.GET)
    @GetMapping("/articles/{id}")
    public ResponseEntity<Article> getArticle(@PathVariable("id") Long id) {
        Article article = Article.builder()
                .id(id)
                .author("niit")
                .content("Sprint Boot Restful 接口")
                .createTime(new Date())
                .title("Spring Boot入门")
                .build();
        log.info("article:" + article);

        return ResponseEntity.ok(article);
    }

    // 增加一篇Article ，使用POST方法，RequestBody方式接收参数
    // @RequestMapping(value = "/articles", method = RequestMethod.POST)
    @PostMapping("/articles")
    public ResponseEntity<String> saveArticle(@RequestBody Article article) {
        log.info("saveArticle: " + article);
        return ResponseEntity.ok("保存成功");
    }

    // 更新一篇Article，使用PUT方法，以id为主键更新
    // @RequestMapping(value = "/articles", method = RequestMethod.PUT)
    @PutMapping("/articles")
    public ResponseEntity<String> updateArticle(@RequestBody Article article) {
        if (article.getId() == null) {
            // article.id是必传参数，因为通常根据id去修改数据
            // TODO 抛出一个自定义的异常
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        log.info("updateArticle: " + article);
        return ResponseEntity.ok("更新成功");
    }

    // 删除一篇Article，使用DELETE方法，参数为id
    // @RequestMapping(value = "/articles/{id}", method = RequestMethod.DELETE)
    @DeleteMapping("/articles/{id}")
    public ResponseEntity<String> deleteArticle(@PathVariable("id") Long id) {
        log.info("deleteArticle: " + id);
        return ResponseEntity.ok("删除成功");
    }

    // 增加一篇Article，使用POST方法，RequestParam方式接收参数
//    @PostMapping("/articles")
//    public ResponseResult saveArticle(@RequestParam String author,
//                                    @RequestParam String title,
//                                    @RequestParam String content,
//                                    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
//                                    @RequestParam Date createTime) {
//
//        log.info("saveArticle:" + createTime);
//        return ResponseResult.success();
//    }
}

//@ApiOperation(value = "添加文章", notes = "添加新的文章", tags = "Article", httpMethod = "POST")
//@ApiImplicitParams({
//        @ApiImplicitParam(name = "article", value = "文章对象", required = true, dataType = "Article")
//})
//@ApiResponses({
//        @ApiResponse(code = 200, message = "成功", response = ResponseEntity.class)
//})
