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
import kodlamaio.hrms.validationCodeService.ValidationCodeManager;

@Service
public class EmailSendManagerAdapter implements EmailSendService {

	private EmailSendManager emailSendManager;
	private ValidationCodeManager validationCodeManager;
	private static Logger log = LoggerFactory.getLogger(EmailSendManagerAdapter.class);

	@Autowired
	public EmailSendManagerAdapter(EmailSendManager emailSendManager, ValidationCodeManager validationCodeManager) {
		this.emailSendManager = emailSendManager;
		this.validationCodeManager = validationCodeManager;
	}

	@Override
	public void emailSend(String email) {
		emailSendManager.emailSending(email);

	}

	@Override
	public Result run(String email) throws Exception {
		long code = this.validationCodeManager.createCode();

		log.info("HRMS - Doğrulama Kodu Gönderildi");

		Email mail = new Email();
		mail.setFrom("HRMS");
		mail.setTo(email);
		mail.setSubject("HRMS - Doğrulama Kodu");
		mail.setContent("Merhaba, \n\n Hesabınzı doğrulamanız için gereken doğrulama kodu: "+code);

		emailSendManager.sendSimpleMessage(mail);
		return new SuccessResult("Email Gönderildi");
	}

}
