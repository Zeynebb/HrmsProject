package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.WorkExperienceService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.core.utilities.result.SuccessDataResult;
import kodlamaio.hrms.core.utilities.result.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.WorkExperienceDao;
import kodlamaio.hrms.entities.concretes.WorkExperience;
import kodlamaio.hrms.entities.dtos.WorkExperienceWithCvWithJobPositionDto;
import kodlamaio.hrms.entities.dtos.WorkExperienceWithCvWithJobSeekerDto;

@Service
public class WorkExperienceManager implements WorkExperienceService {

	private WorkExperienceDao workExperienceDao;

	@Autowired
	public WorkExperienceManager(WorkExperienceDao workExperienceDao) {
		super();
		this.workExperienceDao = workExperienceDao;
	}

	@Override
	public DataResult<List<WorkExperience>> getAll() {
		return new SuccessDataResult<List<WorkExperience>>(this.workExperienceDao.findAll());
	}

	@Override
	public Result add(WorkExperience workExperience) {
		this.workExperienceDao.save(workExperience);
		return new SuccessResult("İş tecrübesi eklendi.");
	}

	@Override
	public DataResult<List<WorkExperienceWithCvWithJobSeekerDto>> getWorkExperienceWithCvWithJobSeekerDateils(
			int userId) {
		return new SuccessDataResult<List<WorkExperienceWithCvWithJobSeekerDto>>(
				this.workExperienceDao.getWorkExperienceWithCvWithJobSeekerDateils(userId));
	}

	@Override
	public DataResult<List<WorkExperienceWithCvWithJobPositionDto>> getWorkExperienceWithCvWithJobPositionDetails(
			int cvId) {
		return new SuccessDataResult<List<WorkExperienceWithCvWithJobPositionDto>>(this.workExperienceDao.getWorkExperienceWithCvWithJobPositionDetails(cvId),
				"İş Tecrübeleri Listelendi");
	}

	@Override
	public Result deleteByWorkExperienceId(int workExperienceId) {
		this.workExperienceDao.deleteByWorkExperienceId(workExperienceId);
		return new SuccessResult("İş tecrübesi silindi.");
	}

}
