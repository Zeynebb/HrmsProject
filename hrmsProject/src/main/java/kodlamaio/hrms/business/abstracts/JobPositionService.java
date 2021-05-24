package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.JobPosition;

public interface JobPositionService {
	
	public List<JobPosition> getAll();
	public Result add(JobPosition jobPosition);

}
