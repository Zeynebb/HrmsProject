package kodlamaio.hrms.emailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.entities.concretes.Email;

@Service
public class EmailSendManager {
	
	private JavaMailSender emailSender;
	
	@Autowired
	public EmailSendManager(JavaMailSender emailSender) {
		super();
		this.emailSender = emailSender;
	}
	public void sendSimpleMessage(Email email) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setSubject(email.getSubject());
		message.setText(email.getContent());
		message.setTo(email.getTo());
		message.setFrom(email.getFrom());
		
		emailSender.send(message);
	}
	
	public void emailSending(String email) {
		System.out.println("'"+email+"' adresine doğrulama e-postası gönderildi.");
	}

}
