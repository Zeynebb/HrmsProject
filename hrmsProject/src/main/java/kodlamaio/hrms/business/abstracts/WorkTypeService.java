package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.entities.concretes.WorkType;

public interface WorkTypeService {
	
	
	public DataResult<List<WorkType>> getAll();

}
