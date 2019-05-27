package gh.ttms.service;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import javax.mail.MessagingException;

public interface MailService {
    public void sendSimpleMail(String to,String content) throws MessagingException;
    public void setJavaMailSender(JavaMailSender javaMailSender);
    public void setSimpleMailMessage(SimpleMailMessage simpleMailMessage);
}
