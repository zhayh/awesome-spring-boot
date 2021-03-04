package com.example.spring.web;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author : zhayh
 * @date : 2021-3-4 09:35
 * @description :
 */

@ControllerAdvice
public class CustomExceptionHandler {
//    @ExceptionHandler(MaxUploadSizeExceededException.class)
//    public void handleMaxSizeException(MaxUploadSizeExceededException e,
//                                       HttpServletResponse response) throws IOException {
//        response.setContentType("text/html;charset=utf-8");
//        PrintWriter out = response.getWriter();
//        out.write("上传文件大小超出限制");
//        out.flush();
//        out.close();
//        System.out.println("上传文件大小超出限制");
//    }

    @ExceptionHandler(MaxUploadSizeExceededException.class)
    public ModelAndView customException(MaxUploadSizeExceededException e) {
        ModelAndView mv = new ModelAndView();
        mv.addObject("error", "上传文件大小超出限制");
        mv.setViewName("error");
        return mv;
    }
}
