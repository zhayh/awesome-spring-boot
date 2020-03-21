package com.spring.restful.pojo;

import com.spring.restful.exception.CustomException;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author : zhayh
 * @date : 2020-2-18 09:08
 * @description : Message的持久层对象Persisent Object
 */

@Data
public class Message {
    private Long id;
    @NonNull
    private String text;
    private String summary;
}
