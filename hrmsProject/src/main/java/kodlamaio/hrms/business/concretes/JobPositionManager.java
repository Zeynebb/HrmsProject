package kodlamaio.hrms.business.concretes;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import kodlamaio.hrms.business.abstracts.JobPositionService;
import kodlamaio.hrms.core.utilities.result.ErrorResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.core.utilities.result.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobPositionDao;
import kodlamaio.hrms.entities.concretes.JobPosition;

@Service
public class JobPositionManager implements JobPositionService {

	private JobPositionDao jobPositionDao;
	private List<String> jobPositions = new ArrayList<>();

	@Autowired
	public JobPositionManager(JobPositionDao jobPositionDao) {
		super();
		this.jobPositionDao = jobPositionDao;
	}

	@Override
	public List<JobPosition> getAll() {
		return jobPositionDao.findAll();
	}

	@Override
	public Result add(JobPosition jobPosition) {
		Result result = new ErrorResult("İş Pozisyonu Eklenemedi!");
		if (positionIsItUsed(jobPosition.getPositionName())) {
			this.jobPositionDao.save(jobPosition);
			result = new SuccessResult("Pozisyon Başarıyla Eklendi");
		}
		return result;
	}

	public boolean positionIsItUsed(String positionName) {
		boolean result = true;
		if(getAllEmail().contains(positionName)) {
			result = false;
		}
		return result;
	}
	@Override
	public List<String> getAllEmail(){
		for (int i = 0; i < getAll().size(); i++) {
			jobPositions.add(getAll().get(i).getPositionName());
		}
		return jobPositions;
	}

}
