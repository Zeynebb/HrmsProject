package kodlamaio.hrms.business.concretes;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.ErrorResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.core.utilities.result.SuccessDataResult;
import kodlamaio.hrms.core.utilities.result.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobAdvertisementDao;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import kodlamaio.hrms.entities.dtos.JobAdvertisementWithEmployerWithJobPositionDto;

@Service
public class JobAdvertisementManager implements JobAdvertisementService {

	private JobAdvertisementDao jobAdvertisementDao;

	@Autowired
	public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao) {
		super();
		this.jobAdvertisementDao = jobAdvertisementDao;
	}

	@Override
	public Result jobAdvertisementAdd(JobAdvertisement jobAdvertisement) {
		Result result = new ErrorResult("Ekleme Başarısız!");
		if (!jobAdvertisement.getJobDescription().isEmpty()) {
			jobAdvertisement.setApprovalStatus(false);
			this.jobAdvertisementDao.save(jobAdvertisement);
			result = new SuccessResult("Ekleme Başarılı");
		}
		return result;
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAll() {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findAll(),"İş İlanları Listelendi");
	}

	@Override
	public DataResult<List<JobAdvertisement>> getByAdvertisementStatus(boolean status) {
		String message = "Aktif ";
		if (status == false) {
			message = "Pasif ";
		}
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getByAdvertisementStatus(status),
				message + " İş İlanları Listelendi.");
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAllSorted() {
		Sort sort = Sort.by(Direction.ASC, "applicationDeadline");
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findAll(sort),
				"İş İlanları Listelendi.");
	}

	@Override
	public DataResult<List<JobAdvertisement>> getByEmployer_userId(int userId) {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getByEmployer_userId(userId),
				"Firmanın İş İlanları Listelendi.");
	}

	@Override
	public Result updateJobAdvertisementSetJobAdvertisementStatusForEmployer_userId(int jobAdvertisementId,
			int employerId) {
		this.jobAdvertisementDao.updateJobAdvertisementSetJobAdvertisementStatusForEmployer_userId(jobAdvertisementId,
				employerId);
		return new SuccessResult("İlan Kapatıldı!");
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAllActiveSorted() {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getAllActiveSorted(),
				"İş İlanları Listelendi.");
	}

	@Override
	public DataResult<List<JobAdvertisementWithEmployerWithJobPositionDto>> getJobAdvertisementWithEmployerWithJobPositionDetails() {
		return new SuccessDataResult<List<JobAdvertisementWithEmployerWithJobPositionDto>>(
				this.jobAdvertisementDao.getJobAdvertisementWithEmployerWithJobPositionDetails(),
				"İş İlanları Tablo Şekinde Listelendi Listelendi.");
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAllApproveStatus(boolean status) {
		String message = "Onaylanmış ";
		if (status == false) {
			message = "Onaylanmamış ";
		}
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getByApprovalStatus(status),
				message + " İş İlanları Listelendi.");
	}

	@Override
	public DataResult<List<JobAdvertisement>> getByJobAdvertisementId(int id) {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getByJobAdvertisementId(id), "İş İlanı Listelendi.");
	}
}
