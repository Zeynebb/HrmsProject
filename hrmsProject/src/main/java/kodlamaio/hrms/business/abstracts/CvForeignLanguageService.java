package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.CvForeignLanguage;
import kodlamaio.hrms.entities.dtos.CvForeignLanguageWithForeignLanguageDto;

public interface CvForeignLanguageService {
	
	public DataResult<List<CvForeignLanguage>> getAll();
	
	public Result deleteByForeignLanguageId(int cvForeignLanguageId);
		
	public Result add(CvForeignLanguage cvForeignLanguage);

	DataResult<List<CvForeignLanguageWithForeignLanguageDto>> getCvForeignLanguageWithForeignLanguageDetails(int cvId);
}
