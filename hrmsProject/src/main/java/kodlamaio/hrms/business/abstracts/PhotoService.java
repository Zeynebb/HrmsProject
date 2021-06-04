package kodlamaio.hrms.business.abstracts;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.Photo;

public interface PhotoService {
	
	public Result add(Photo photo, MultipartFile multipartFile) throws IOException;
	
	public Result update(int cvId, MultipartFile multipartFile) throws IOException;
	
	public Result delete(String id) throws IOException;
	

}
