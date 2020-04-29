package com.spring.mail;

import freemarker.template.Configuration;
import freemarker.template.Template;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.io.StringWriter;
import java.util.Date;
import java.util.HashMap;

/**
 * @author : zhayh
 * @date : 2020-4-29 16:58
 * @description :
 */
@RestController
public class MailController {
    @Autowired
    JavaMailSender javaMailSender;

    @GetMapping("/simple")
    public String sendSimpleMail() {
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setSubject("主题：测试邮件");
        msg.setText("这是测试邮件的内容");
        msg.setFrom("494720292@qq.com");
        msg.setSentDate(new Date());
        msg.setTo("494720292@qq.com");
        javaMailSender.send(msg);
        return "发送成功";
    }

    @GetMapping("/file")
    public String sendFileMail() throws MessagingException {
        MimeMessage msg = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(msg, true);
        helper.setSubject("主题：测试带附件邮件");
        helper.setText("这是测试带附件邮件的内容");
        helper.setFrom("494720292@qq.com");
        helper.setSentDate(new Date());
        helper.setTo("494720292@qq.com");
        helper.addAttachment("img1.jpg", new File("E:\\02-back end\\img1.jpg"));
        helper.addAttachment("img2.jpg", new File("E:\\02-back end\\img2.jpg"));
        javaMailSender.send(msg);
        return "发送成功";
    }

    @GetMapping("/image")
    public String sendImageMail() throws MessagingException {
        MimeMessage msg = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(msg, true);
        helper.setSubject("主题：测试带图片邮件");
        helper.setText("这是测试带附件图片的内容，图片1：<img src='cid:a1' />", true);
        helper.setFrom("494720292@qq.com");
        helper.setSentDate(new Date());
        helper.setTo("494720292@qq.com");
        helper.addInline("a1", new FileSystemResource("E:\\02-back end\\img1.jpg"));
        javaMailSender.send(msg);
        return "发送成功";
    }

    @Autowired
    TemplateEngine templateEngine;

    @GetMapping("/thymeleaf")
    public String sendThymeleafMail() throws MessagingException {
        MimeMessage msg = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(msg, true);

        helper.setSubject("主题：测试Thymeleaf模板邮件");
        Context context = new Context();
        context.setVariable("username", "张三");
        context.setVariable("position", "Java工程师");
        context.setVariable("salary", 8000);

        String process = templateEngine.process("mail.html", context);
        helper.setText(process, true);
        helper.setFrom("494720292@qq.com");
        helper.setSentDate(new Date());
        helper.setTo("494720292@qq.com");
        javaMailSender.send(msg);

        return "发送成功";
    }

    @GetMapping("/freemarker")
    public String sendFreemarkerMail() throws Exception {
        MimeMessage msg = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(msg, true);

        helper.setSubject("主题：测试Freemarker模板邮件");
        helper.setFrom("494720292@qq.com");
        helper.setSentDate(new Date());
        helper.setTo("494720292@qq.com");

        //构建 Freemarker 的基本配置
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_30);
        // 配置模板位置
        configuration.setClassLoaderForTemplateLoading(
                this.getClass().getClassLoader(), "templates");
        //加载模板
        Template template = configuration.getTemplate("mail.ftl");
        // 组织数据
        HashMap<String, Object> map = new HashMap<>();
        map.put("username", "张三");
        map.put("position", "Java工程师");
        map.put("salary", 8000);

        //模板渲染，渲染的结果将被保存到 out中 ，将 out中的 html字符串发送即可
        StringWriter out = new StringWriter();
        template.process(map, out);
        helper.setText(out.toString(), true);
        javaMailSender.send(msg);

        return "发送成功";
    }
}
