package kodlamaio.hrms.business.concretes;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import kodlamaio.hrms.business.abstracts.CvService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.core.utilities.result.SuccessDataResult;
import kodlamaio.hrms.core.utilities.result.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CvDao;
import kodlamaio.hrms.dataAccess.abstracts.CvForeignLanguageDao;
import kodlamaio.hrms.dataAccess.abstracts.CvSocialMediaDao;
import kodlamaio.hrms.dataAccess.abstracts.CvTechnologyDao;
import kodlamaio.hrms.dataAccess.abstracts.EducationInformationDao;
import kodlamaio.hrms.dataAccess.abstracts.PhotoDao;
import kodlamaio.hrms.dataAccess.abstracts.WorkExperienceDao;
import kodlamaio.hrms.entities.concretes.Cv;
import kodlamaio.hrms.entities.dtos.CvWithJobSeekerDto;

@Service
public class CvManager implements CvService {

	private CvDao cvDao;
	private EducationInformationDao educationInformationDao;
	private WorkExperienceDao workExperienceDao;
	private CvForeignLanguageDao cvForeignLanguageDao;
	private CvSocialMediaDao cvSocialMediaDao;
	private CvTechnologyDao cvTechnologyDao;
	private PhotoDao photoDao;

	@Autowired
	public CvManager(CvDao cvDao, EducationInformationDao educationInformationDao, WorkExperienceDao workExperienceDao,
			CvForeignLanguageDao cvForeignLanguageDao, CvSocialMediaDao cvSocialMediaDao,
			CvTechnologyDao cvTechnologyDao, PhotoDao photoDao) {
		super();
		this.cvDao = cvDao;
		this.educationInformationDao = educationInformationDao;
		this.workExperienceDao = workExperienceDao;
		this.cvForeignLanguageDao = cvForeignLanguageDao;
		this.cvSocialMediaDao = cvSocialMediaDao;
		this.cvTechnologyDao = cvTechnologyDao;
		this.photoDao = photoDao;
	}
	@Override
	public DataResult<List<Cv>> getAll() {
		return new SuccessDataResult<List<Cv>>(this.cvDao.findAll());
	}

	@Override
	public Result add(Cv cv) {
		this.cvDao.save(cv);
		return new SuccessResult("Özgeçmiş eklendi.");
	}

	@Override
	public DataResult<List<Cv>> getByCvIdForJobSeeker_UserId(int userId) {
		return new SuccessDataResult<List<Cv>>(this.cvDao.getByCvIdForJobSeekerId(userId));
	}

	@Override
	public DataResult<List<CvWithJobSeekerDto>> getCvWithJobSeekerDetails(int cvId) {
		return new SuccessDataResult<List<CvWithJobSeekerDto>>(this.cvDao.getCvWithJobSeekerDetails(cvId),
				"Cv Listelendi");
	}

	@Override
	public Result updateCv(Cv cv, int cvId, int jobSeekerId) {
		cv.setCvId(cvId);
		return null;
	}

	@Override
	public Result updateCvSetCreationDate(int cvId) {
		Date date = new Date(System.currentTimeMillis());
		this.cvDao.updateCvSetCreationDate(cvId, date);
		return new SuccessResult("Oluşturulma Tarihi Güncellendi");
	}

	@Override
	public Result deleteCvSetObjective(int cvId) {
		this.cvDao.deleteCvSetObjective(cvId);
		return new SuccessResult("Ön Söz Silindi");
	}

	@Override
	public Result delete(int cvId) {
		this.educationInformationDao.deleteByCv_CvId(cvId);
		this.workExperienceDao.deleteByCv_CvId(cvId);
		this.cvForeignLanguageDao.deleteByCv_CvId(cvId);
		this.cvSocialMediaDao.deleteByCv_CvId(cvId);
		this.cvTechnologyDao.deleteByCv_CvId(cvId);
		this.photoDao.deleteByCv_CvId(cvId);
		this.cvDao.deleteByCvId(cvId);		
		return new SuccessResult("Özgeçmiş Silindi");
	}
}
