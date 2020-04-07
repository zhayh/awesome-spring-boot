package com.mybatis.annotation.param;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author : zhayh
 * @date : 2020-4-6 20:20
 * @description : Message的分页类
 */

@Data
@EqualsAndHashCode(callSuper=true)
public class MessageParam extends PageParam{
    private Integer msgId;
    private String msgText;
    private String msgSummary;
}
