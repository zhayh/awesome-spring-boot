package com.mybatis.pagehelper.model;

import lombok.Builder;
import lombok.Data;

/**
 * @author : zhayh
 * @date : 2020-4-6 10:21
 * @description :
 */

@Data
@Builder
public class Message {
    private Integer msgId;
    private String msgText;
    private String msgSummary;
}
