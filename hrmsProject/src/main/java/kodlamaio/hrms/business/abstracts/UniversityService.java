package kodlamaio.hrms.business.abstracts;

import java.util.List;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.entities.concretes.University;

public interface UniversityService {
	
	public DataResult<List<University>> getAll();

}
