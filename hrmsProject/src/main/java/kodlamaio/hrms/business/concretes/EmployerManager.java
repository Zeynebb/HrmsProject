package kodlamaio.hrms.business.concretes;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.google.common.base.Objects;
import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.core.abstracts.EmailDomainCheckService;
import kodlamaio.hrms.core.abstracts.EmailSendService;
import kodlamaio.hrms.core.utilities.result.ErrorResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.core.utilities.result.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.entities.concretes.Employer;

@Service
public class EmployerManager implements EmployerService {

	private EmployerDao employerDao;
	private EmailSendService emailSendService;
	private EmailDomainCheckService emailDomainChekService;
	private List<String> emails = new ArrayList<>();

	@Autowired
	public EmployerManager(EmployerDao employerDao, EmailSendService emailSendService,
			EmailDomainCheckService emailDomainChekService) {
		super();
		this.employerDao = employerDao;
		this.emailSendService = emailSendService;
		this.emailDomainChekService = emailDomainChekService;
	}

	@Override
	public List<Employer> getAll() {
		return this.employerDao.findAll();
	}

	@Override
	public Result register(Employer employer, String passwordAgain) {
		Result result = new ErrorResult("Kayıt Başarısız!");
		if (emailIsItUsed(employer.getEmail()) && Objects.equal(passwordAgain, employer.getPassword())
				&& emailDomainChekService.domainCheck(employer.getEmail(), employer.getWebsite())
				&& employer.getPhoneNumber().length()!=11) {
			emailSendService.emailSend(employer.getEmail());
			employer.setVerificationStatus(false);// default
			this.employerDao.save(employer);
			result = new SuccessResult("Kayıt Başarılı");
		}
		return result;
	}

	public boolean emailIsItUsed(String email) {
		boolean result = true;
		if (getAllEmails().contains(email)) {
			result = false;
		}
		return result;
	}

	@Override
	public List<String> getAllEmails() {
		for (int i = 0; i < getAll().size(); i++) {
			emails.add(getAll().get(i).getEmail());
		}
		return emails;
	}

}
