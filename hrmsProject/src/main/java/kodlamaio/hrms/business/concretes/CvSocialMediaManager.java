package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CvSocialMediaService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.core.utilities.result.SuccessDataResult;
import kodlamaio.hrms.core.utilities.result.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CvSocialMediaDao;
import kodlamaio.hrms.entities.concretes.CvSocialMedia;
import kodlamaio.hrms.entities.dtos.CvSocialMediaWithSocialMediaDto;

@Service
public class CvSocialMediaManager implements CvSocialMediaService {

	private CvSocialMediaDao cvSocialMediaDao;

	@Autowired
	public CvSocialMediaManager(CvSocialMediaDao cvSocialMediaDao) {
		super();
		this.cvSocialMediaDao = cvSocialMediaDao;
	}

	@Override
	public DataResult<List<CvSocialMedia>> getAll() {
		return new SuccessDataResult<List<CvSocialMedia>>(this.cvSocialMediaDao.findAll());
	}

	@Override
	public Result add(CvSocialMedia cvSocialMedia) {
		this.cvSocialMediaDao.save(cvSocialMedia);
		return new SuccessResult("Sosyal meyda bilgileri eklendi.");
	}

	@Override
	public DataResult<List<CvSocialMediaWithSocialMediaDto>> getCvSocialMediaWithSocialMediaDetails(int cvId) {
		return new SuccessDataResult<List<CvSocialMediaWithSocialMediaDto>>(this.cvSocialMediaDao.getCvSocialMediaWithSocialMediaDetails(cvId),
				"Sosyal Medyalar Listelendi");
	}

}
