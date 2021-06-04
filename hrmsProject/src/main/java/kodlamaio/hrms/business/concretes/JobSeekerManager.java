package kodlamaio.hrms.business.concretes;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.google.common.base.Objects;
import kodlamaio.hrms.business.abstracts.JobSeekerService;
import kodlamaio.hrms.core.abstracts.EmailCheckService;
import kodlamaio.hrms.core.abstracts.EmailSendService;
import kodlamaio.hrms.core.abstracts.MernisCheckService;
import kodlamaio.hrms.core.utilities.result.ErrorResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.core.utilities.result.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobSeekerDao;
import kodlamaio.hrms.entities.concretes.JobSeeker;

@Service
public class JobSeekerManager implements JobSeekerService {

	private EmailCheckService emailCheckService;
	private JobSeekerDao jobSeekerDao;
	private EmailSendService emailSendService;
	private MernisCheckService mernisCheckService;

	@Autowired
	public JobSeekerManager(EmailCheckService emailCheckService, JobSeekerDao jobSeekerDao,
			EmailSendService emailSendService, MernisCheckService mernisCheckService) {
		super();
		this.emailCheckService = emailCheckService;
		this.jobSeekerDao = jobSeekerDao;
		this.emailSendService = emailSendService;
		this.mernisCheckService = mernisCheckService;
	}

	@Override
	public Result register(JobSeeker jobSeeker, String passwordAgain) {
		Result result = new ErrorResult("Kayıt Başarısız!");
		if (emailCheckService.emailCheck(jobSeeker.getEmail()) && emailIsItUsed(jobSeeker.getEmail())
				&& nationalityIdIsItUsed(jobSeeker.getNationalityId())
				&& mernisCheckService.checkIfRealPerson(jobSeeker)
				&& Objects.equal(passwordAgain, jobSeeker.getPassword())) {
			emailSendService.emailSend(jobSeeker.getEmail());
			this.jobSeekerDao.save(jobSeeker);
			result = new SuccessResult("Kayıt Başarılı.");
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

	public boolean nationalityIdIsItUsed(String nationalityId) {
		boolean result = true;
		if (getAllNationalityId().contains(nationalityId)) {
			result = false;
		}
		return result;
	}

	@Override
	public List<JobSeeker> getAll() {
		return this.jobSeekerDao.findAll();
	}

	@Override
	public List<String> getAllEmails() {
		return this.jobSeekerDao.getByEmail();
	}

	@Override
	public List<String> getAllNationalityId() {
		return this.jobSeekerDao.getByNationalityId();
	}

}
