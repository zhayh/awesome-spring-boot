package com.spring.restful.custom.controller;

import com.spring.restful.custom.pojo.Message;
import com.spring.restful.custom.validator.MessageValidator;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author : zhayh
 * @date : 2020-3-30 20:48
 * @description : 自定义校验器的测试
 */
@RestController
public class CustomValidatorController {
    /**
     * 调用控制器前先执行这个方法
     *
     * @param binder
     */
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        // 绑定验证器
        binder.setValidator(new MessageValidator());
        // 定义日期参数格式，参数不再需注解@DateTimeFormat，boolean参数表示是否允许为空
        binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), false));
    }
    /**
     * 验证url: http://localhost:8080/msgValidator?msg=1&date=2020-01-01
     * @param msg Message对象
     * @param Errors 验证器返回的错误
     * @param date 因为WebDataBinder已经绑定了格式，所以不再需要注解
     * @return 各类数据
     */
    @GetMapping("/msgValidator")
    public Map<String, Object> validator(@Valid Message msg, Errors Errors, Date date) {
        Map<String, Object> map = new HashMap<>();
        map.put("msg", msg);
        map.put("date", date);
        // 判断是否存在错误
        if (Errors.hasErrors()) {
            // 获取全部错误
            List<ObjectError> objErrors = Errors.getAllErrors();
            for (ObjectError error : objErrors) {
                // 判定是否字段错误
                if (error instanceof FieldError) {
                    // 字段错误
                    FieldError fe = (FieldError) error;
                    map.put(fe.getField(), fe.getDefaultMessage());
                } else {
                    // 对象错误
                    map.put(error.getObjectName(), error.getDefaultMessage());
                }
            }
        }
        return map;
    }
}
