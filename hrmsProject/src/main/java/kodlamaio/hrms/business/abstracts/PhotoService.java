package kodlamaio.hrms.business.abstracts;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.Photo;

public interface PhotoService {
	
	public DataResult<List<Photo>> getAll();
	
	public Result add(Photo photo, MultipartFile multipartFile) throws IOException;
	
	public Result update(int cvId, MultipartFile multipartFile) throws IOException;
	
	public Result delete(String id) throws IOException;
	
	public DataResult<Photo> getByPhotoForCvId(int cvId);
	

}
