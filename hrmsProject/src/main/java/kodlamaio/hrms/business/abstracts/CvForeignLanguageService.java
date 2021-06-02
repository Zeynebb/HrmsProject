package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.CvForeignLanguage;

public interface CvForeignLanguageService {
	
	public DataResult<List<CvForeignLanguage>> getAll();
	
	public Result add(CvForeignLanguage cvForeignLanguage);

}
