package com.ejobim.opplat.util;

import com.sun.mail.util.MailSSLSocketFactory;
import org.apache.commons.lang.StringUtils;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.util.Properties;

public class SendMailAcceUtils {
    /**
     * 发送带附件的邮件
     *
     * @param receive
     *            收件人
     * @param subject
     *            邮件主题
     * @param msg
     *            邮件内容
     * @param filename
     *            附件地址
     * @return
     * @throws GeneralSecurityException
     */
    public static boolean sendMail(String receive, String subject, String msg,String filePath, String filename)
            throws Exception {
        if (StringUtils.isEmpty(receive)) {
            return false;
        }

        // 发件人电子邮箱
        final String from = "wujl@ejobim.com";
        // 发件人电子邮箱密码
        final String pass = "Wjl147258";

        // 指定发送邮件的主机为 smtp.qq.com
        String host = "smtp.mxhichina.com"; // 邮件服务器

        // 获取系统属性
        Properties properties = System.getProperties();

        // 设置邮件服务器
        properties.setProperty("mail.smtp.host", host);

        properties.put("mail.smtp.auth", "true");
        MailSSLSocketFactory sf = new MailSSLSocketFactory();
        sf.setTrustAllHosts(true);
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.ssl.socketFactory", sf);
        // 获取默认session对象
        Session session = Session.getDefaultInstance(properties, new Authenticator() {
            public PasswordAuthentication getPasswordAuthentication() { // qq邮箱服务器账户、第三方登录授权码
                return new PasswordAuthentication(from, pass); // 发件人邮件用户名、密码
            }
        });

        try {
            // 创建默认的 MimeMessage 对象
            MimeMessage message = new MimeMessage(session);

            // Set From: 头部头字段
            message.setFrom(new InternetAddress(from));

            // Set To: 头部头字段
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(receive));

            // Set Subject: 主题文字
            message.setSubject(subject);

            // 创建消息部分
            BodyPart messageBodyPart = new MimeBodyPart();

            // 消息
            messageBodyPart.setText(msg);

            // 创建多重消息
            Multipart multipart = new MimeMultipart();

            // 设置文本消息部分
            multipart.addBodyPart(messageBodyPart);

            // 附件部分
            messageBodyPart = new MimeBodyPart();
            // 设置要发送附件的文件路径
            DataSource source = new FileDataSource(filePath);
            messageBodyPart.setDataHandler(new DataHandler(source));

            // messageBodyPart.setFileName(filename);
            // 处理附件名称中文（附带文件路径）乱码问题
            messageBodyPart.setFileName(MimeUtility.encodeText(filename));
            multipart.addBodyPart(messageBodyPart);

            // 发送完整消息
            message.setContent(multipart);

            // 发送消息
            Transport.send(message);
             System.out.println("Sent message successfully....");
            return true;
        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return false;
    }
    public static void main(String[] args) throws Exception {
        String receive = "791144917@qq.com";
        String subject = "邮件主题";
        String msg = "邮件内容";
        String filePath = "D:\\数据底稿.xlsx";
        String filename = "数据底稿.xlsx";
        try {
            SendMailAcceUtils.sendMail(receive, subject, msg, filePath,filename);
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
        }
    }
}
