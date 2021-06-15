package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CvTechnologyService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.core.utilities.result.SuccessDataResult;
import kodlamaio.hrms.core.utilities.result.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CvTechnologyDao;
import kodlamaio.hrms.entities.concretes.CvTechnology;
import kodlamaio.hrms.entities.dtos.CvTechnologyWithTechnologyDto;

@Service
public class CvTechnologyManager implements CvTechnologyService{
	
	private CvTechnologyDao cvTechnologyDao;

	@Autowired
	public CvTechnologyManager(CvTechnologyDao cvTechnologyDao) {
		super();
		this.cvTechnologyDao = cvTechnologyDao;
	}

	@Override
	public DataResult<List<CvTechnology>> getAll() {
		return new SuccessDataResult<List<CvTechnology>>(this.cvTechnologyDao.findAll());
	}

	@Override
	public Result add(CvTechnology cvTechnology) {
		this.cvTechnologyDao.save(cvTechnology);
		return new SuccessResult("Programlama dili eklendi.");
	}

	@Override
	public DataResult<List<CvTechnologyWithTechnologyDto>> getCvTechnologyWithTechnologydetails(int cvId) {
		return new SuccessDataResult<List<CvTechnologyWithTechnologyDto>>(this.cvTechnologyDao.getCvTechnologyWithTechnologydetails(cvId),"Teknolojiler Listelendi");
	}

}
