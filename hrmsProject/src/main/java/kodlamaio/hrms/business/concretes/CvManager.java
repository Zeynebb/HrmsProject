package kodlamaio.hrms.business.concretes;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import kodlamaio.hrms.business.abstracts.CvService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.core.utilities.result.SuccessDataResult;
import kodlamaio.hrms.core.utilities.result.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CvDao;
import kodlamaio.hrms.entities.concretes.Cv;
import kodlamaio.hrms.entities.dtos.CvWithJobSeekerDto;

@Service
public class CvManager implements CvService {

	private CvDao cvDao;

	@Autowired
	public CvManager(CvDao cvDao) {
		super();
		this.cvDao = cvDao;
	}

	@Override
	public DataResult<List<Cv>> getAll() {
		return new SuccessDataResult<List<Cv>>(this.cvDao.findAll());
	}

	@Override
	public Result add(Cv cv) {
		this.cvDao.save(cv);
		return new SuccessResult("Özgeçmiş eklendi.");
	}

	@Override
	public DataResult<List<Cv>> getByCvIdForJobSeeker_UserId(int userId) {
		return new SuccessDataResult<List<Cv>>(this.cvDao.getByCvIdForJobSeekerId(userId));
	}

	@Override
	public DataResult<List<CvWithJobSeekerDto>> getCvWithJobSeekerDetails(int cvId) {
		return new SuccessDataResult<List<CvWithJobSeekerDto>>(this.cvDao.getCvWithJobSeekerDetails(cvId), "Cv Listelendi");
	}

	@Override
	public Result updateCv(Cv cv, int cvId, int jobSeekerId) {
		cv.setCvId(cvId);
		return null;
	}
}
