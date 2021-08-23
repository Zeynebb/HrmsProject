package kodlamaio.hrms.core.concretes;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.core.abstracts.EmailSendService;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.core.utilities.result.SuccessResult;
import kodlamaio.hrms.emailService.EmailSendManager;
import kodlamaio.hrms.entities.concretes.Email;

@Service
public class EmailSendManagerAdapter implements EmailSendService {

	private EmailSendManager emailSendManager;
	private static Logger log = LoggerFactory.getLogger(EmailSendManagerAdapter.class);

	@Autowired
	public EmailSendManagerAdapter(EmailSendManager emailSendManager) {
		this.emailSendManager = emailSendManager;
	}

	@Override
	public void fakeEmailSend(String email, long verificationCode) {
		emailSendManager.emailSending(email);

	}

	@Override
	public Result sendEmail(String email, long verificationCode) throws Exception {
		log.info("HRMS - Doğrulama Kodu Gönderildi");

		Email mail = new Email();
		mail.setFrom("HRMS");
		mail.setTo(email);
		mail.setSubject("HRMS - Doğrulama Kodu");
		mail.setContent("Merhaba, \n\n Hesabınzı doğrulamanız için gereken doğrulama kodu: " + verificationCode);

		emailSendManager.sendSimpleMessage(mail);
		return new SuccessResult("Email Gönderildi");
	}

}
