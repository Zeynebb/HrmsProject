package kodlamaio.hrms.business.concretes;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.google.common.base.Objects;
import kodlamaio.hrms.business.abstracts.JobSeekerService;
import kodlamaio.hrms.business.abstracts.ValidationCodeService;
import kodlamaio.hrms.core.abstracts.EmailCheckService;
import kodlamaio.hrms.core.abstracts.EmailSendService;
import kodlamaio.hrms.core.abstracts.MernisCheckService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.ErrorResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.core.utilities.result.SuccessDataResult;
import kodlamaio.hrms.core.utilities.result.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobSeekerDao;
import kodlamaio.hrms.entities.concretes.JobSeeker;

@Service
public class JobSeekerManager implements JobSeekerService {

	private EmailCheckService emailCheckService;
	private JobSeekerDao jobSeekerDao;
	private EmailSendService emailSendService;
	private MernisCheckService mernisCheckService;
	private ValidationCodeService validationCodeService;
	private long code;

	@Autowired
	public JobSeekerManager(EmailCheckService emailCheckService, JobSeekerDao jobSeekerDao,
			EmailSendService emailSendService, MernisCheckService mernisCheckService,
			ValidationCodeService validationCodeService) {
		super();
		this.emailCheckService = emailCheckService;
		this.jobSeekerDao = jobSeekerDao;
		this.emailSendService = emailSendService;
		this.mernisCheckService = mernisCheckService;
		this.validationCodeService = validationCodeService;
	}

	@Override
	public Result register(JobSeeker jobSeeker, String passwordAgain, long validationCode) {
		Result result = new ErrorResult("Kayıt Başarısız!");
		if (emailCheckService.emailCheck(jobSeeker.getEmail()) && emailIsItUsed(jobSeeker.getEmail())
				&& nationalityIdIsItUsed(jobSeeker.getNationalityId())
				&& mernisCheckService.checkIfRealPerson(jobSeeker)
				&& Objects.equal(passwordAgain, jobSeeker.getPassword())) {
			this.jobSeekerDao.save(jobSeeker);
			result = new SuccessResult("Kayıt Başarılı.");
		}
		return result;
	}

	@Override
	public Result emailVerification(JobSeeker jobSeeker, String passwordAgain, long validationCode) throws Exception {
		Result result = new ErrorResult("Doğrulama Başarısız!");
		if (code == validationCode) {
			register(jobSeeker, passwordAgain, validationCode);
			result = new SuccessResult("Doğrulama Başarılı!");
		}
		return result;
	}

	@Override
	public Result emailSending(String email) throws Exception  {
		Result result = new ErrorResult("Email Gönderilemedi!");
		code = validationCodeService.codeCreate();
		if (emailCheckService.emailCheck(email) && emailIsItUsed(email)) {
			emailSendService.sendEmail(email, code);
			result =new SuccessResult("Email Gönderildi");
		}		
		return result;
	}
	@Override
	public boolean emailIsItUsed(String email) {
		boolean result = true;
		if (getAllEmails().contains(email)) {
			result = false;
		}
		return result;
	}
	@Override
	public boolean nationalityIdIsItUsed(String nationalityId) {
		boolean result = true;
		if (getAllNationalityId().contains(nationalityId)) {
			result = false;
		}
		return result;
	}

	@Override
	public DataResult<List<JobSeeker>> getAll() {
		return new SuccessDataResult<>(this.jobSeekerDao.findAll(), "Data Listelendi");
	}

	@Override
	public List<String> getAllEmails() {
		return this.jobSeekerDao.getByEmail();
	}

	@Override
	public List<String> getAllNationalityId() {
		return this.jobSeekerDao.getByNationalityId();
	}

	@Override
	public DataResult<JobSeeker> getJobSeekerByUserId(int userId) {
		return new SuccessDataResult<JobSeeker>(this.jobSeekerDao.getJobSeekerByUserId(userId),
				"İş Arayan Listelendi.");
	}

}
