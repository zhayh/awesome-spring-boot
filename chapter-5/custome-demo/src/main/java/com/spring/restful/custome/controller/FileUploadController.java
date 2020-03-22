package com.spring.restful.custome.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

/**
 * @author : zhayh
 * @date : 2020-3-22 08:05
 * @description : 文件上传
 */

@RestController
public class FileUploadController {

    @PostMapping("/upload")
    public String upload(MultipartFile file, HttpServletRequest request) {
        String format = LocalDate.now().format(DateTimeFormatter.ofPattern("/yyyy/MM/dd/"));
        String realPath = request.getServletContext().getRealPath("/img") + format;
        File folder = new File(realPath);
        if(!folder.exists()) {
            folder.mkdirs();
        }
        String oldName = file.getOriginalFilename();
        String newName = UUID.randomUUID().toString() + oldName.substring(oldName.lastIndexOf("."));

        try {
            file.transferTo(new File(folder, newName));
            String url = request.getScheme() + "://" + request.getServerName() + ":"
                    + request.getServerPort() + "/img" + format + newName;
            return url;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "error";
    }
}
