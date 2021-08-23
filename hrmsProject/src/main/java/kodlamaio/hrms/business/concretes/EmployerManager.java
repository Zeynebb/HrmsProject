package kodlamaio.hrms.business.concretes;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Objects;
import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.business.abstracts.ValidationCodeService;
import kodlamaio.hrms.core.abstracts.EmailDomainCheckService;
import kodlamaio.hrms.core.abstracts.EmailSendService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.ErrorResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.core.utilities.result.SuccessDataResult;
import kodlamaio.hrms.core.utilities.result.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.dataAccess.abstracts.UserDao;
import kodlamaio.hrms.entities.concretes.Employer;

@Service
public class EmployerManager implements EmployerService {

	private EmployerDao employerDao;
	private EmailSendService emailSendService;
	private EmailDomainCheckService emailDomainChekService;
	private UserDao userDao;
	private ObjectMapper objectMapper;
	private ValidationCodeService validationCodeService;
	private long code;

	@Autowired
	public EmployerManager(EmployerDao employerDao, EmailSendService emailSendService,
			EmailDomainCheckService emailDomainChekService, UserDao userDao, ObjectMapper objectMapper,
			ValidationCodeService validationCodeService) {
		super();
		this.employerDao = employerDao;
		this.emailSendService = emailSendService;
		this.emailDomainChekService = emailDomainChekService;
		this.userDao = userDao;
		this.objectMapper = objectMapper;
		this.validationCodeService = validationCodeService;
	}

	@Override
	public List<Employer> getAll() {
		return this.employerDao.findAll();
	}

	@Override
	public Result register(Employer employer, String passwordAgain, long validationCode) {
		Result result = new ErrorResult("Kayıt Başarısız!");
		if (code == validationCode) {
			if (Objects.equal(passwordAgain, employer.getPassword())) {
				employer.setVerificationStatus(false);// default
				this.employerDao.save(employer);
				result = new SuccessResult("Kayıt Başarılı");
			}
		}
		return result;
	}

	@Override
	public Result emailSending(String email, String website) throws Exception {
		Result result = new ErrorResult("Email Gönderilemedi!");
		code = validationCodeService.codeCreate();
		if (emailDomainChekService.domainCheck(email, website) && emailIsItUsed(email)) {
			emailSendService.sendEmail(email, code);
			result = new SuccessResult("Email Gönderildi");
		}
		return result;
	}

	// yeni bir employer icerisine guncellenecek employer'in bilgileri ataniyor
	// girilen employer bilgileri --> json objesi
	// yeni employer'in update isimli degiskenine json objesi set ediliyor
	// employer yeni bilgileriyle kaydedildi
	@Override
	public Result update(Employer employer) {
		Result result = new ErrorResult("Güncelleme Başarısız!");
		if (emailDomainChekService.domainCheck(employer.getEmail(), employer.getWebsite())) {
			Employer updatedEmployer = getByUserId(employer.getUserId()).getData();
			Map<String, Object> update = this.objectMapper.convertValue(employer, Map.class);
			updatedEmployer.setUpdateStatus(false);
			updatedEmployer.setUpdate(update);
			this.employerDao.save(updatedEmployer);
			result = new SuccessResult("Güncelleme Başarılı");
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
	public List<String> getAllEmails() {
		return this.userDao.getAllEmails();
	}

	@Override
	public Result login(String email, String password) {
		Result result = new ErrorResult("Giriş Başarısız!");
		if (Objects.equal(this.userDao.getPasswordByEmail(email), password)) {
			result = new SuccessResult("Giriş Başarılı.");
		}
		return result;
	}

	@Override
	public DataResult<List<Employer>> getAllEmployerByVerificationStatus(boolean status) {
		return new SuccessDataResult<List<Employer>>(this.employerDao.getAllEmployerByVerificationStatus(status),
				"İş Verenler Listelendi.");
	}

	@Override
	public DataResult<Employer> getByUserId(int userId) {
		return new SuccessDataResult<Employer>(this.employerDao.getByUserId(userId), "İş Veren Bilgileri Listelendi.");
	}

	@Override
	public DataResult<Map<String, Object>> getUpdateByUserId(int userId) {
		return new SuccessDataResult<>(this.employerDao.getUpdateByUserId(userId), "Güncellenmiş bilgiler listelendi.");
	}

	@Override
	public Result updatedEmployerVerification(int employerId) {
		Map<String, Object> updatedInfo = getUpdateByUserId(employerId).getData();
		Employer newEmployer = new Employer();
		newEmployer.setUserId(employerId);
		newEmployer.setEmail(updatedInfo.get("email").toString());
		newEmployer.setPassword(updatedInfo.get("password").toString());
		newEmployer.setCompanyName(updatedInfo.get("companyName").toString());
		newEmployer.setWebsite(updatedInfo.get("website").toString());
		newEmployer.setPhoneNumber(updatedInfo.get("phoneNumber").toString());
		newEmployer.setUpdateStatus(true);
		this.employerDao.save(newEmployer);
		return new SuccessResult("Güncelleme Onaylandı!");
	}

	@Override
	public DataResult<List<Employer>> getAllUpdatedEmployer() {
		return new SuccessDataResult<List<Employer>>(this.employerDao.findByUpdateNotNull(),
				"Güncellenmiş iş verenler listelendi");
	}

}
