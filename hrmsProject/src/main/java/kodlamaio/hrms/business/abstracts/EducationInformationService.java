package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.EducationInformation;
import kodlamaio.hrms.entities.dtos.EducationInformationWithCvWithUniversityWithUniversityDepartmentDto;

public interface EducationInformationService {
	
	public DataResult<List<EducationInformation>> getAll();
	
	public Result add(EducationInformation educationInformation);
	
	
	DataResult<List<EducationInformationWithCvWithUniversityWithUniversityDepartmentDto>>
	getEducationInformationWithCvWithUniversityWithUniversityDepartmentDetails(int cvId);

}
