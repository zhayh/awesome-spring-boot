package com.spring.restful.custom.pojo;

import com.alibaba.fastjson.annotation.JSONField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NonNull;

import java.util.Date;

/**
 * @author : zhayh
 * @date : 2020-2-18 09:08
 * @description : Message的持久层对象Persisent Object
 */

@Data
@ApiModel(value = "消息对象")
public class Message {
    @ApiModelProperty(notes = "消息ID", name = "id", required = true, dataType = "Long", value = "1")
    private Long id;
    @ApiModelProperty(notes = "正文", name = "text", required = true, value = "正文")
    private String text;
    @ApiModelProperty(notes = "摘要", name = "summary", required = true, value = "摘要")
    private String summary;
//    @JSONField(format = "yyyy-MM-dd hh:mm:dd")
    @ApiModelProperty(notes = "创建时间", name = "createTime", dataType = "Date", value = "2020-03-21T13:31:34.268+0000")
    private Date createTime;
}


/*
@JSONField(format = "yyyy-MM-dd hh:mm:dd")
fastjson的Date数据格式： 2020-03-21T13:31:34.268+0000
 */
