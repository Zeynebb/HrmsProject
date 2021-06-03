package kodlamaio.hrms.core.abstracts;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

public interface CloudinaryService {
	
	public Map photoUpload(MultipartFile multipartFile) throws IOException;
	
	public Map photoDelete(String id) throws IOException;
	
	public File convert(MultipartFile multipartFile) throws IOException;

}
