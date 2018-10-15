package org.huangding.redismqregister.email;

import java.io.File;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

/**
 * @author huangding
 * @description
 * @date 2018/10/15 10:20
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class EmailServiceTest {

    @Autowired
    private EmailService emailService;

    @Autowired
    private TemplateEngine templateEngine;


    @Test
    public void testSendTextMsg() {
        emailService.sendTextMsg("test", "nmd", "huangding520156@163.com");
    }

    @Test
    public void testSendHTMLMsg() {
        Context context = new Context();
        context.setVariable("name","zhangssss");
        String html = templateEngine.process("emailTemplate", context);
        log.info(html);
//        String html = temp

//        String html ="<html><body><h1>html ----</h1></body></html>";
        emailService.sendHTMLMsg("test", html, "huangding520156@163.com");


    }

    @Test
    public void testSendHTMLAndFileMsg() {
        String html ="<html><body><h1>html ----</h1></body></html>";
//        File file = new File("C:\\Users\\24020\\Desktop\\微盟.txt");
        File file = new File("D:\\谷歌下载\\b542b6121057130e33d33d04d52a27f7.jpg");

        emailService.sendHTMLAndFileMsg("test", html,file, "huangding520156@163.com");
    }


    @Test
    public void testSendHTMLAndInlineFileMsg() {
        String html = "<html><body><h1>html ----</h1></body></html>";
        File file = new File("D:\\谷歌下载\\b542b6121057130e33d33d04d52a27f7.jpg");
        emailService.sendHTMLAndInlineFileMsg("test", html, file, "huangding520156@163.com");
    }
}
