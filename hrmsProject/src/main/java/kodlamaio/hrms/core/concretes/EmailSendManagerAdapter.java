package kodlamaio.hrms.core.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.core.abstracts.EmailSendService;
import kodlamaio.hrms.emailService.EmailSendManager;

@Service
public class EmailSendManagerAdapter implements EmailSendService {

	private EmailSendManager emailSendManager;

	@Autowired
	public EmailSendManagerAdapter(EmailSendManager emailSendManager) {
		this.emailSendManager = emailSendManager;
	}

	@Override
	public void emailSend(String email) {
		emailSendManager.emailSending(email);

	}

}
