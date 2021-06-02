package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.CvTechnology;

public interface CvTechnologyService {
	
	public DataResult<List<CvTechnology>> getAll();
	
	public Result add(CvTechnology cvTechnology);

}