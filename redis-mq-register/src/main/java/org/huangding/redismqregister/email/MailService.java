package org.huangding.redismqregister.email;

import java.io.File;

public interface MailService {


    /**
     * @param subject 标题
     * @param content 内容
     * @param to 目标
     */
    void sendTextMsg(String subject, String content, String... to);

    /**
     * @param subject 标题
     * @param content 内容
     * @param to 目标
     */
    void sendHTMLMsg(String subject, String content, String... to);

    /**
     * 带附件的方法
     * @param subject
     * @param content
     * @param file
     * @param to
     */
    void sendHTMLAndInlineFileMsg(String subject, String content, File file, String... to);

    /**
     * 带静态资源的方法
     * @param subject
     * @param content
     * @param file
     * @param to
     */
    void sendHTMLAndFileMsg(String subject, String content, File file, String... to);



    /**
     * @param subject 标题
     * @param content 内容
     * @param to 目标
     */
    void sendMimeMsg(String subject, String content, String... to);
}
