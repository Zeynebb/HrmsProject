package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import kodlamaio.hrms.entities.dtos.JobAdvertisementWithEmployerWithJobPositionDto;

public interface JobAdvertisementService {

	public DataResult<List<JobAdvertisement>> getAll();

	public DataResult<List<JobAdvertisement>> getAllSorted();

	public DataResult<JobAdvertisement> getByJobAdvertisementId(int id);

	public DataResult<List<JobAdvertisement>> getAllSortedJobAdvertisementByStatusForEmployerId(boolean status,
			int employerId);

	public DataResult<List<JobAdvertisement>> getAllSortedJobAdvertisementByStatus(boolean status);

	public DataResult<List<JobAdvertisement>> getAllApproveStatus(boolean status);

	public DataResult<List<JobAdvertisement>> getByEmployer_userId(int userId);

	public DataResult<List<JobAdvertisement>> getByAdvertisementStatus(boolean status);

	public DataResult<List<JobAdvertisement>> getByAdvertisementStatusAndApprovalStatus();

	public Result jobAdvertisementAdd(JobAdvertisement jobAdvertisement);

	public Result updateJobAdvertisementSetJobAdvertisementStatusForEmployer_userId(int jobAdvertisementId,
			int employerId, boolean status);

	public Result updateJobAdvertisementSetApprovalStatus(int jobAdvertisementId, boolean status);

	public DataResult<List<JobAdvertisementWithEmployerWithJobPositionDto>> getJobAdvertisementWithEmployerWithJobPositionDetails();

	public DataResult<List<JobAdvertisement>> getAllByPageSize(int pageNo, int pageSize);

}
