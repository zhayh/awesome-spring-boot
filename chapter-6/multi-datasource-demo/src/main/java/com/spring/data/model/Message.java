package com.spring.data.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author : zhayh
 * @date : 2020-2-18 09:08
 * @description : Message的持久层对象Persisent Object
 */

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Message {
    private Long id;
    private String content;
    private String summary;
}
