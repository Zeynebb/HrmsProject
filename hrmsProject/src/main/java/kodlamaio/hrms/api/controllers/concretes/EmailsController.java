package kodlamaio.hrms.api.controllers.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.core.abstracts.EmailSendService;
import kodlamaio.hrms.core.utilities.result.Result;


@RestController
@RequestMapping("/api/emails")
@CrossOrigin
public class EmailsController {

	private EmailSendService emailSendService;
	
	@Autowired
	public EmailsController(EmailSendService emailSendService) {
		super();
		this.emailSendService = emailSendService;
	}

	@PostMapping
	public Result run(@RequestParam String email) throws Exception{
		return this.emailSendService.run(email);
	}
}
