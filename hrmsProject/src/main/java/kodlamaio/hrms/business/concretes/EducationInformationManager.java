package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import kodlamaio.hrms.business.abstracts.EducationInformationService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.core.utilities.result.SuccessDataResult;
import kodlamaio.hrms.core.utilities.result.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EducationInformationDao;
import kodlamaio.hrms.entities.concretes.EducationInformation;
import kodlamaio.hrms.entities.dtos.EducationInformationWithCvWithUniversityWithUniversityDepartmentDto;

@Service
public class EducationInformationManager implements EducationInformationService {

	private EducationInformationDao educationInformationDao;	
	
	@Autowired
	public EducationInformationManager(EducationInformationDao educationInformationDao) {
		super();
		this.educationInformationDao = educationInformationDao;
	}

	@Override
	public DataResult<List<EducationInformation>> getAll() {
		return new SuccessDataResult<List<EducationInformation>>(this.educationInformationDao.findAll());
	}

	@Override
	public Result add(EducationInformation educationInformation) {
		if(educationInformation.getGraduationDate().isEmpty()) {
			educationInformation.setGraduationDate("Devam Ediyor");
		}
		this.educationInformationDao.save(educationInformation);
		return new SuccessResult("Eğitim bilgisi eklendi");
	}

	@Override
	public DataResult<List<EducationInformationWithCvWithUniversityWithUniversityDepartmentDto>> 
	getEducationInformationWithCvWithUniversityWithUniversityDepartmentDetails(int cvId) {
		return new SuccessDataResult<List<EducationInformationWithCvWithUniversityWithUniversityDepartmentDto>>(
				this.educationInformationDao.getEducationInformationWithCvWithUniversityWithUniversityDepartmentDetails(cvId));
	}

}
