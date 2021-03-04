package com.example.spring.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * @author : zhayh
 * @date : 2021-3-2 20:49
 * @description :
 */

@RestController
public class FileController {
    @Value("${file.download.path}")
    private String downloadPath;

    @PostMapping("/upload")
    public String upload(MultipartFile file, HttpServletRequest request) {
        // 格式化目录
        String format = LocalDate.now().format(DateTimeFormatter.ofPattern("/yyyy/MM/dd/"));
        String path = request.getServletContext().getRealPath(("/image")) + format;
        File folder = new File(path);
        // 若路径不存在，则创建
        if (!folder.exists()) {
            folder.mkdirs();
        }
        // 修改文件名
        String oldFileName = file.getOriginalFilename();
        String newFileName = UUID.randomUUID().toString() + oldFileName.substring(oldFileName.lastIndexOf("."));

        // 保存文件
        try {
            file.transferTo(new File(folder, newFileName));
            return request.getScheme() + "://" + request.getServerName() + ":"
                    + request.getServerPort() + "/image" + format + newFileName;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "上传失败！";
    }

    @PostMapping("/uploads")
    public String upload(MultipartFile[] files, HttpServletRequest request) {
        List<String> uploadUrls = Arrays.stream(files)
                .map(file -> upload(file, request))
                .collect(Collectors.toList());
        return String.join(",", uploadUrls);
    }

    @GetMapping("/download/{fileName}")
    public String download(HttpServletRequest request, HttpServletResponse response,
                           @PathVariable("fileName") String fileName) throws Exception {
        try {
            File file = new File(downloadPath + "/" + fileName);
            if (!file.exists()) {
                return "下载文件不存在";
            }

            fileName = getFilename(request, fileName);
            // 设置响应头
            response.reset();
            response.setContentType("application/octet-stream");
            response.setCharacterEncoding(StandardCharsets.UTF_8.toString());
            response.setContentLength(((int) file.length()));
            response.setHeader("Content-Disposition",
                    "attachment;filename="+fileName);

            // 下载文件
            int i = 0;
            byte[] buf = new byte[1024];
            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
            OutputStream os = response.getOutputStream();
            while((i = bis.read(buf)) != -1) {
                os.write(buf, 0, i);
                os.flush();
            }
            os.close();
            bis.close();
        } catch (IOException e) {
            e.printStackTrace();
            return "下载失败";
        }
        return "下载成功";

    }

    // 根据浏览器的不同进行编码设置，返回编码后的文件名
    private String getFilename(HttpServletRequest request, String fileName)
            throws Exception {
        // IE不同版本User-Agent中出现的关键词
        String[] ieBrowserKeyWords = {"MSIE", "Trident", "Edge"};
        // 获取请求头代理信息
        String userAgent = request.getHeader("User-Agent");
        for (String keyWord : ieBrowserKeyWords) {
            if (userAgent.contains(keyWord)) {
                // IE内核浏览器，统一为UTF-8编码显示，并对转换的+进行更正
                return URLEncoder.encode(fileName, StandardCharsets.UTF_8)
                        .replace("+", " ");
            }
        }
        // 其它浏览器统一为ISO-8859-1编码显示
        return new String(fileName.getBytes(StandardCharsets.UTF_8),
                StandardCharsets.ISO_8859_1);
    }
}
