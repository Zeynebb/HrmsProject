package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.entities.concretes.ForeignLanguage;

public interface ForeignLanguageService {
	
	public DataResult<List<ForeignLanguage>> getAll();

}
