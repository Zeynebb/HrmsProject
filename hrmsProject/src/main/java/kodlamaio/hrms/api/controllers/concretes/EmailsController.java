package kodlamaio.hrms.api.controllers.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.core.abstracts.EmailCheckService;


@RestController
@RequestMapping("/api/emails")
@CrossOrigin
public class EmailsController {

	private EmailCheckService emailCheckService;

	@Autowired
	public EmailsController(EmailCheckService emailCheckService) {
		super();
		this.emailCheckService = emailCheckService;
	}

	@GetMapping("/emailCheck")
	public boolean emailCheck(@RequestParam String email) {
		return this.emailCheckService.emailCheck(email);
	}
}
