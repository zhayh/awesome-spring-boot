package com.example.spring.json.article;

import com.example.spring.json.ResponseEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
    public ResponseEntity getArticle(@PathVariable("id") Long id) {
        List<Reader> readers = new ArrayList<>(){{
            add(new Reader("张三", 20));
            add(new Reader("李四", 19));
        }};
        Article article = Article.builder()
                .id(1L)
                .author("niit")
                .content("Sprint Boot Restful 接口")
                .createTime(new Date())
                .title("Spring Boot入门")
                .readers(readers)
                .build();

        log.info("article:" + article);

        return ResponseEntity.success(article);
    }


    // 增加一篇Article ，使用POST方法，RequestBody方式接收参数
    // @RequestMapping(value = "/articles", method = RequestMethod.POST)
    @PostMapping("/articles")
    public ResponseEntity saveArticle(@RequestBody Article article) {
        log.info("saveArticle: " + article);
        return ResponseEntity.success();
    }

    // 更新一篇Article，使用PUT方法，以id为主键更新
    // @RequestMapping(value = "/articles", method = RequestMethod.PUT)
    @PutMapping("/articles")
    public ResponseEntity updateArticle(@RequestBody Article article) {
        if (article.getId() == null) {
            // article.id是必传参数，因为通常根据id去修改数据
            // TODO 抛出一个自定义的异常
        }
        log.info("updateArticle: " + article);
        return ResponseEntity.success();
    }

    // 删除一篇Article，使用DELETE方法，参数为id
    // @RequestMapping(value = "/articles/{id}", method = RequestMethod.DELETE)
    @DeleteMapping("/articles/{id}")
    public ResponseEntity deleteArticle(@PathVariable("id") Long id) {
        log.info("deleteArticle: " + id);
        return ResponseEntity.success();
    }

    // 增加一篇Article，使用POST方法，RequestParam方式接收参数
//    @PostMapping("/articles")
//    public AjaxResponse saveArticle(@RequestParam String author,
//                                    @RequestParam String title,
//                                    @RequestParam String content,
//                                    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
//                                    @RequestParam Date createTime) {
//
//        log.info("saveArticle:" + createTime);
//        return AjaxResponse.success();
//    }
}
