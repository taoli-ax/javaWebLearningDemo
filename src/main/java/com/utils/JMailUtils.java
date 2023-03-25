package com.utils;


import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;

public class JMailUtils {
    public static void send(String activeLink) {
        //设置发件人和收件人的电子邮件地址
        String from = "deuta-tao@outlook.com";
        String to = "deuta-tao@outlook.com";

        // Outlook.com SMTP服务器的配置信息
        String host = "smtp.office365.com";
        int port = 587;
        String password = "PLA78088@";

        // 使用TLS加密连接
        Properties props = new Properties();
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", port);

        // 使用用户名和密码进行身份验证
        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(from, password);
                    }
                });

        try {
            // 创建电子邮件消息对象
            Message message = new MimeMessage(session);

            // 设置电子邮件消息的发件人，收件人，主题和正文
            message.setFrom(new InternetAddress(from));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(to));
            message.setSubject("测试邮件");
            message.setText("这是一封测试邮件！");
            message.setText(activeLink);

            // 发送电子邮件消息
            Transport.send(message);

            System.out.println("邮件发送成功！");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}