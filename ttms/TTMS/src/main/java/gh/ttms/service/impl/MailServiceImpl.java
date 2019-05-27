package gh.ttms.service.impl;

import gh.ttms.service.MailService;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;

@Service("mailService")
public class MailServiceImpl implements MailService {

    private JavaMailSender javaMailSender;
    private SimpleMailMessage simpleMailMessage;
    @Override
    public void sendSimpleMail(String to, String content) throws MessagingException {
        try {
            System.out.println(to);
            System.out.println(content);
            if (simpleMailMessage==null){
                System.out.println("md没装配！！！");
            }
            simpleMailMessage.setTo(to);
            simpleMailMessage.setText(content);
            javaMailSender.send(simpleMailMessage);
        }catch (Exception e){
            throw new MessagingException("发送邮件失败!",e);
        }
    }

    @Override
    public void setJavaMailSender(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    @Override
    public void setSimpleMailMessage(SimpleMailMessage simpleMailMessage) {
        this.simpleMailMessage = simpleMailMessage;
    }
}
