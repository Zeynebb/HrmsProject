package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.entities.concretes.UniversityDepartment;

public interface UniversityDepartmentService {
	public DataResult<List<UniversityDepartment>> getAll();

}
