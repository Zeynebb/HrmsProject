package kodlamaio.hrms.business.abstracts;

import java.util.List;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;

public interface JobAdvertisementService {
	
	public List<JobAdvertisement> getAll();
	public DataResult<List<JobAdvertisement>> getAllSorted();
	
	public DataResult<List<JobAdvertisement>> getByEmployer_userId(int userId);
	public DataResult<List<JobAdvertisement>> getByAdvertisementStatus(boolean status);	
	public Result jobAdvertisementAdd(JobAdvertisement jobAdvertisement);
	
	public Result updateJobAdvertisementSetJobAdvertisementStatusForEmployer_userId(int jobAdvertisementId, int employerId);

}
