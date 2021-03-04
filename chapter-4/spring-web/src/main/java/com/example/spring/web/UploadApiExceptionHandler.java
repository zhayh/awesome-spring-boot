package com.example.spring.web;

import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.http.fileupload.impl.FileSizeLimitExceededException;
import org.apache.tomcat.util.http.fileupload.impl.SizeLimitExceededException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.multipart.MultipartException;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author : zhayh
 * @date : 2021-3-4 15:50
 * @description : 使用postman测试
 */

@Slf4j
//@RestControllerAdvice
public class UploadApiExceptionHandler {
    @ExceptionHandler(value = MultipartException.class)
    public String handleBusinessException(MaxUploadSizeExceededException ex) {
        String msg;
        if (ex.getCause().getCause() instanceof FileSizeLimitExceededException) {
            log.error(ex.getMessage());
            msg = "上传文件过大[单文件大小不得超过10M]";
        } else if (ex.getCause().getCause() instanceof SizeLimitExceededException) {
            log.error(ex.getMessage());
            msg = "上传文件过大[总上传文件大小不得超过10M]";
        } else {
            msg = "上传文件失败";
        }
        return msg;
    }

//    @ExceptionHandler(MaxUploadSizeExceededException.class)
//    public void handleMaxSizeException(MaxUploadSizeExceededException e,
//                                       HttpServletResponse response) throws IOException {
//        response.setContentType("text/html;charset=utf-8");
//        PrintWriter out = response.getWriter();
//        out.write("上传文件大小超出限制");
//        out.flush();
//        out.close();
//    }
}
