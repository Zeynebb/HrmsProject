package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.CvTechnology;
import kodlamaio.hrms.entities.dtos.CvTechnologyWithTechnologyDto;

public interface CvTechnologyService {
	
	public DataResult<List<CvTechnology>> getAll();
	
	public Result add(CvTechnology cvTechnology);
	
	public DataResult<List<CvTechnologyWithTechnologyDto>> getCvTechnologyWithTechnologydetails(int cvId);

}
