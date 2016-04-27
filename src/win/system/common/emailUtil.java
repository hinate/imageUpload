package win.system.common;

import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * Created  2016/3/25.
 */
public class emailUtil {

    public static void  sedEmail(String to,String content){

        JavaMailSenderImpl senderImpl = new JavaMailSenderImpl();

        // 设定mail server
        senderImpl.setHost("smtp.163.com");

        // 建立邮件消息,发送简单邮件和html邮件的区别
        MimeMessage mailMessage = senderImpl.createMimeMessage();
        MimeMessageHelper messageHelper = new MimeMessageHelper(mailMessage,"utf-8");

        // 设置收件人，寄件人
        try {
            messageHelper.setTo(to);
        } catch (MessagingException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        try {
            messageHelper.setFrom("h1nate@163.com");
        } catch (MessagingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            messageHelper.setSubject("Hinate-图库");
        } catch (MessagingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        // true 表示启动HTML格式的邮件
        try {
            messageHelper
                    .setText("<div style=\"padding:0; width:798px; overflow:hidden; margin:0 auto; font-family:'Microsoft YaHei'; font-size:14px; border:solid 1px #ddd;\"><div style=\"width:100%; height:50px; margin:0 0 54px; background:#00CCFF;\"><span style=\"font-size:28px; line-height:5px; font-family:'Microsoft YaHei'; color:#FFF; float:left; margin:20px 0 0 48px;\">Hinate-图库</span></div><div style=\"margin:0; padding:0 0 0 49px;\"><h3 style=\"margin:0; font-size:20px; color:#333333; line-height:24px;\">Hinate-图库验证码</h3><p style=\"margin:0; padding:20px 0 12px 0; color:#555555;\">"
                                    +   content+
                                    "</p><p style=\"color:#999999; margin:0; padding:10px 0 80px 0;\">(您若未注册Hinate-图库请忽略此邮件，敬请谅解) </p></div></div>"
                            ,true);
        } catch (MessagingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        senderImpl.setUsername("h1nate@163.com"); // 根据自己的情况,设置username
        senderImpl.setPassword("lyjlj1314#"); // 根据自己的情况, 设置password
        Properties prop = new Properties();
        prop.put("mail.smtp.auth", "true"); // 将这个参数设为true，让服务器进行认证,认证用户名和密码是否正确
        prop.put("mail.smtp.timeout", "25000");
        senderImpl.setJavaMailProperties(prop);
        // 发送邮件
        senderImpl.send(mailMessage);

    }
}
