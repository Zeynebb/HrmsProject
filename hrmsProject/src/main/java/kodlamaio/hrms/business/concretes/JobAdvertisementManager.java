package kodlamaio.hrms.business.concretes;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findAll(),
				"İş İlanları Listelendi");
	}

	@Override // Aktif-pasif iş ilanları listeleme
	public DataResult<List<JobAdvertisement>> getByAdvertisementStatus(boolean status) {
		String message = "Aktif ";
		if (status == false) {
			message = "Pasif ";
		}
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getByAdvertisementStatus(status),
				message + " İş İlanları Listelendi.");
	}

	@Override // tüm iş ilanları - sıralı
	public DataResult<List<JobAdvertisement>> getAllSorted() {
		Sort sort = Sort.by(Direction.ASC, "applicationDeadline");
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findAll(sort),
				"İş İlanları Listelendi.");
	}

	@Override // employer'a ait iş ilanları
	public DataResult<List<JobAdvertisement>> getByEmployer_userId(int userId) {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getByEmployer_userId(userId),
				"Firmanın İş İlanları Listelendi.");
	}

	@Override // iş ilanı aktif-pasif
	public Result updateJobAdvertisementSetJobAdvertisementStatusForEmployer_userId(int jobAdvertisementId,
			int employerId, boolean status) {
		String message = "İlan Kapatıldı!";
		if (status == true) {
			message = "İlan Aktif Hale Getirildi!";
		}
		this.jobAdvertisementDao.updateJobAdvertisementSetJobAdvertisementStatusForEmployer_userId(jobAdvertisementId,
				employerId, status);
		return new SuccessResult(message);
	}

	@Override // aktif-pasif iş ilanları sıralı
	public DataResult<List<JobAdvertisement>> getAllSortedJobAdvertisementByStatus(boolean status) {
		return new SuccessDataResult<List<JobAdvertisement>>(
				this.jobAdvertisementDao.getAllSortedJobAdvertisementByStatus(status), "İş İlanları Listelendi.");
	}

	@Override
	public DataResult<List<JobAdvertisementWithEmployerWithJobPositionDto>> getJobAdvertisementWithEmployerWithJobPositionDetails() {
		return new SuccessDataResult<List<JobAdvertisementWithEmployerWithJobPositionDto>>(
				this.jobAdvertisementDao.getJobAdvertisementWithEmployerWithJobPositionDetails(),
				"İş İlanları Tablo Şekinde Listelendi.");
	}

	@Override // Onaylanmış-Onaylanmamış iş ilanları
	public DataResult<List<JobAdvertisement>> getAllApproveStatus(boolean status) {
		String message = "Onaylanmış ";
		if (status == false) {
			message = "Onaylanmamış ";
		}
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getByApprovalStatus(status),
				message + " İş İlanları Listelendi.");
	}

	@Override // id'ya göre ilan getirme
	public DataResult<JobAdvertisement> getByJobAdvertisementId(int id) {
		return new SuccessDataResult<JobAdvertisement>(this.jobAdvertisementDao.getByJobAdvertisementId(id));
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAllSortedJobAdvertisementByStatusForEmployerId(boolean status,
			int employerId) {
		return new SuccessDataResult<List<JobAdvertisement>>
		(this.jobAdvertisementDao.getAllSortedJobAdvertisementByStatusForEmployerId(status, employerId), "İş İlanları Listelendi.");
	}

	@Override//personel onaylama- reddetme
	public Result updateJobAdvertisementSetApprovalStatus(int jobAdvertisementId, boolean status) {
		String message = "İlan Onaylandı!";
		if (status == false) {
			message = "İlan Reddedildi!";
		}		
		this.jobAdvertisementDao.updateJobAdvertisementSetApprovalStatus(jobAdvertisementId, status);
		return new SuccessResult(message);
	}
	@Override
	public DataResult<List<JobAdvertisement>> getAllByPageSize(int pageNo, int pageSize) {
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findAll(pageable).getContent());
	}
	
}
