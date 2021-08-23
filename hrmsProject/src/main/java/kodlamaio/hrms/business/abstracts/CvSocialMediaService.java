package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.CvSocialMedia;
import kodlamaio.hrms.entities.dtos.CvSocialMediaWithSocialMediaDto;

public interface CvSocialMediaService {
	
	public DataResult<List<CvSocialMedia>> getAll();
	
	public Result add(CvSocialMedia cvSocialMedia);
	
	public Result deleteByCvSocialMediaId(int cvSocialMediaId);
	
	public DataResult<List<CvSocialMediaWithSocialMediaDto>> getCvSocialMediaWithSocialMediaDetails(int cvId);

}
