package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.WorkExperience;
import kodlamaio.hrms.entities.dtos.WorkExperienceWithCvWithJobPositionDto;
import kodlamaio.hrms.entities.dtos.WorkExperienceWithCvWithJobSeekerDto;

public interface WorkExperienceService {
	
	public DataResult<List<WorkExperience>> getAll();
	
	public Result add(WorkExperience workExperience);
	
	DataResult<List<WorkExperienceWithCvWithJobSeekerDto>> getWorkExperienceWithCvWithJobSeekerDateils(int userId);
	
	DataResult<List<WorkExperienceWithCvWithJobPositionDto>> getWorkExperienceWithCvWithJobPositionDetails(int cvId);

}
