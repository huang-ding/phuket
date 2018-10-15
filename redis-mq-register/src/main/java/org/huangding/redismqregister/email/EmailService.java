package org.huangding.redismqregister.email;

import java.io.File;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

/**
 * @author huangding
 * @description
 * @date 2018/10/9 9:08
 */
@Component
@Slf4j
public class EmailService implements MailService {

    @Autowired
    private JavaMailSender mailSender;

    /**
     * from，即为邮件发送者，一般设置在配置文件中
     */
    @Value("${spring.mail.username}")
    private String from;


    @Override
    public void sendTextMsg(String subject, String content, String... to) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        log.info("form------------------{}", from);
        simpleMailMessage.setFrom(from);
        //to，邮件接收者，此参数可以为数组，同时发送多人
        simpleMailMessage.setTo(to);
        //邮件主题
        simpleMailMessage.setSubject(subject);
        //邮件主体
        simpleMailMessage.setText(content);
        try {
            mailSender.send(simpleMailMessage);
            log.info("邮件发送成功");
        } catch (Exception e) {
            e.printStackTrace();
            log.error("邮件发送失败");
        }
    }

    /**
     * @param subject 标题
     * @param content 内容
     * @param to 目标
     */
    @Override
    public void sendHTMLMsg(String subject, String content, String... to) {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
            helper.setFrom(from);
            helper.setTo(to);
            helper.setSubject(subject);
            //true代表支持html
            helper.setText(content, true);
            mailSender.send(mimeMessage);
        } catch (MessagingException e) {
            log.error("发送html邮件异常");
            e.printStackTrace();
        }

    }


    @Override
    public void sendHTMLAndFileMsg(String subject, String content, File file, String... to) {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
            helper.setFrom(from);
            helper.setTo(to);
            helper.setSubject(subject);
            //true代表支持html
            helper.setText(content, true);
            FileSystemResource fileSource = new FileSystemResource(file);
            helper.addAttachment(fileSource.getFilename(), fileSource);
            mailSender.send(mimeMessage);
        } catch (MessagingException e) {
            log.error("发送html邮件异常");
            e.printStackTrace();
        }
    }

    @Override
    public void sendHTMLAndInlineFileMsg(String subject, String content, File file, String... to) {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
            helper.setFrom(from);
            helper.setTo(to);
            helper.setSubject(subject);
            //true代表支持html
            helper.setText(content, true);
            FileSystemResource fileSource = new FileSystemResource(file);
            helper.addInline(fileSource.getFilename(), fileSource);
            mailSender.send(mimeMessage);
        } catch (MessagingException e) {
            log.error("发送html邮件异常");
            e.printStackTrace();
        }
    }

    @Override
    public void sendMimeMsg(String subject, String content, String... to) {

    }
}
