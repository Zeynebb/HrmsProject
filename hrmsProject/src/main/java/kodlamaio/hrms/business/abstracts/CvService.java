package kodlamaio.hrms.business.abstracts;

import java.util.List;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.Cv;
import kodlamaio.hrms.entities.dtos.CvWithJobSeekerDto;

public interface CvService {
	
	public DataResult<List<Cv>> getAll();
	
	public Result add(Cv cv);
	
	public Result updateCv(Cv cv, int cvId, int jobSeekerId);
	
	public Result updateCvSetCreationDate(int cvId);
	
	public DataResult<List<Cv>> getByCvIdForJobSeeker_UserId(int userId);
	
	public DataResult<List<CvWithJobSeekerDto>> getCvWithJobSeekerDetails(int cvId);
	

}
