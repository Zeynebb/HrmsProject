package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.Cv;

public interface CvService {
	
	public DataResult<List<Cv>> getAll();
	
	public Result add(Cv cv);
	
	public DataResult<List<Cv>> getByCvIdForJobSeeker_UserId(int userId);

}
