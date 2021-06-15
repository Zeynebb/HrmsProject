package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.JobPosition;

public interface JobPositionService {
	
	public DataResult<List<JobPosition>> getAll();
	public Result add(JobPosition jobPosition);

}
