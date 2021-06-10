package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.entities.concretes.Technology;

public interface TechnologyService {
	
	public DataResult<List<Technology>> getAll();

}
