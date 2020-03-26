package com.spring.restful.custom.pojo;

import lombok.Data;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.Date;

/**
 * @author : zhayh
 * @date : 2020-3-25 20:59
 * @description : JSR-303验证
 */
@Data
public class ValidatorPojo {
    @NotNull(message = "id不能为空")
    private Long id;

    @Future(message = "需要一个将来日期")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull
    private LocalDate date;

    @NotNull
    @DecimalMin(value = "0.1")
    @DecimalMax(value = "10000.0")
    private Double doubleValue = null;

    @Min(value = 1, message = "最小值为1")
    @Max(value = 100, message = "最大值为100")
    private Integer integer;

    @Range(min = 1, max = 100, message = "值的范围为1~100")
    private Long range;

    @Email(message = "邮箱格式错误")
    private String email;

    @Size(min = 6, max = 20, message = "字符串长度要求6到20之间")
    private String size;
}
