package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CvForeignLanguageService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.core.utilities.result.SuccessDataResult;
import kodlamaio.hrms.core.utilities.result.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CvForeignLanguageDao;
import kodlamaio.hrms.entities.concretes.CvForeignLanguage;
import kodlamaio.hrms.entities.dtos.CvForeignLanguageWithForeignLanguageDto;

@Service
public class CvForeignLanguageManager implements CvForeignLanguageService {

	private CvForeignLanguageDao cvForeignLanguageDao;

	@Autowired
	public CvForeignLanguageManager(CvForeignLanguageDao cvForeignLanguageDao) {
		super();
		this.cvForeignLanguageDao = cvForeignLanguageDao;
	}

	@Override
	public DataResult<List<CvForeignLanguage>> getAll() {
		return new SuccessDataResult<List<CvForeignLanguage>>(this.cvForeignLanguageDao.findAll());
	}

	@Override
	public Result add(CvForeignLanguage cvForeignLanguage) {
		this.cvForeignLanguageDao.save(cvForeignLanguage);
		return new SuccessResult("Yabancı dil bilgisi eklendi.");
	}

	@Override
	public DataResult<List<CvForeignLanguageWithForeignLanguageDto>> getCvForeignLanguageWithForeignLanguageDetails(
			int cvId) {
		return new SuccessDataResult<>(this.cvForeignLanguageDao.getCvForeignLanguageWithForeignLanguageDetails(cvId),
				"Yabancı Dil Bilgileri Listelendi.");
	}

}
