package com.spring.restful.custom.controller;

import com.spring.restful.custom.common.ExceptionType;
import com.spring.restful.custom.config.IgnoreResponseAdvice;
import com.spring.restful.custom.exception.CustomException;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author : zhayh
 * @date : 2020-3-25 16:15
 * @description : 实现文件上传下载，文件下载时使用@IgnoreResponseAdvice
 */

@RestController
public class FileController {

    @PostMapping("/upload")
    public ResponseEntity<String> upload(MultipartFile file, HttpServletRequest request) {

        String format = LocalDate.now().format(DateTimeFormatter.ofPattern("/yyyy/MM/dd/"));
        String realPath = request.getServletContext().getRealPath("/img") + format;
        File folder = new File(realPath);
        if (!folder.exists()) {
            folder.mkdirs();
        }
        // 修改文件名
        String oldName = file.getOriginalFilename();
        String newName = UUID.randomUUID().toString() + oldName.substring(oldName.lastIndexOf("."));

        try {
            // 保存文件
            file.transferTo(new File(folder, newName));
            String url = request.getScheme() + "://" + request.getServerName() + ":"
                    + request.getServerPort() + "/img" + format + newName;
            return ResponseEntity.ok(url);
        } catch (IOException e) {
            e.printStackTrace();
            throw new CustomException(ExceptionType.OTHER_ERROR.getCode(), e.getMessage());
        }
    }

    @PostMapping("/uploads")
    public ResponseEntity<String> uploads(MultipartFile[] files, HttpServletRequest request) {
//        String format = LocalDate.now().format(DateTimeFormatter.ofPattern("/yyyy/MM/dd/"));
//        String realPath = request.getServletContext().getRealPath("/img") + format;
//        File folder = new File(realPath);
//        if (!folder.exists()) {
//            folder.mkdirs();
//        }
//        List<String> uploadUrls = new ArrayList<>();
//        for (MultipartFile file : files) {
//            String oldName = file.getOriginalFilename();
//            String newName = UUID.randomUUID().toString() + oldName.substring(oldName.lastIndexOf("."));
//
//            try {
//                file.transferTo(new File(folder, newName));
//                String url = request.getScheme() + "://" + request.getServerName() + ":"
//                        + request.getServerPort() + "/img" + format + newName;
//                uploadUrls.add(url);
//            } catch (IOException e) {
//                e.printStackTrace();
//                throw new CustomException(ExceptionType.OTHER_ERROR.getCode(), e.getMessage());
//            }
//        }
        List<String> uploadUrls = Arrays.stream(files)
                .map(file -> upload(file, request))
                .map(ResponseEntity::getBody)
                .collect(Collectors.toList());
        return ResponseEntity.ok(String.join(",", uploadUrls));
    }

    @GetMapping("/download/{filename}")
    @IgnoreResponseAdvice
    public ResponseEntity<FileSystemResource> fileDownload(@PathVariable String filename,
                                                           HttpServletRequest request) {
        File file = new File(dirPath, filename);
        if (!file.exists()) {
            throw new CustomException(ExceptionType.NOT_FOUND_ERROR.getCode(),
                    ExceptionType.NOT_FOUND_ERROR.getMsg());
        }
        try {
            filename = getFilename(request, filename);
            // 设置响应头
            HttpHeaders headers = new HttpHeaders();
            headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
            headers.add("Pragma", "no-cache");
            headers.add("Expires", "0");
            headers.add("Last-Modified", new Date().toString());
            // 以下载形式打开文件
            headers.setContentDispositionFormData("attachment", filename);
            // 使用ResponseEntity下载文件

            return ResponseEntity
                    .ok()
                    .headers(headers)
                    .contentLength(file.length())
                    .contentType(MediaType.APPLICATION_OCTET_STREAM)
                    .body(new FileSystemResource(file));
        } catch (Exception e) {
            e.printStackTrace();
            throw new CustomException(ExceptionType.OTHER_ERROR.getCode(), e.getMessage());
        }
    }

    @Value("${file.download.root.dir}")
    private String dirPath;

    // 根据浏览器的不同进行编码设置，返回编码后的文件名
    private String getFilename(HttpServletRequest request, String filename) throws Exception {
        // IE不同版本User-Agent中出现的关键词
        String[] ieBrowserKeyWords = {"MSIE", "Trident", "Edge"};
        // 获取请求头代理信息
        String userAgent = request.getHeader("User-Agent");
        for (String keyWord : ieBrowserKeyWords) {
            if (userAgent.contains(keyWord)) {
                // IE内核浏览器，统一为UTF-8编码显示，并对转换的+进行更正
                return URLEncoder.encode(filename, "UTF-8").replace("+", " ");
            }
        }
        // 其它浏览器统一为ISO-8859-1编码显示
        return new String(filename.getBytes(StandardCharsets.UTF_8), StandardCharsets.ISO_8859_1);
    }
}
