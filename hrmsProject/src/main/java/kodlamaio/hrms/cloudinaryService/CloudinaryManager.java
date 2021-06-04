package kodlamaio.hrms.cloudinaryService;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

@Service
public class CloudinaryManager {

	Cloudinary cloudinary;

	private Map<String, String> valuesMap = new HashMap<>();

	@Autowired
	public CloudinaryManager() {
		valuesMap.put("cloud_name", "zeydatabase");
		valuesMap.put("api_key", "286744313495218");
		valuesMap.put("api_secret", "DY03XeGJQ51_YkdePMY3PmrCvXs");
		cloudinary = new Cloudinary(valuesMap);

	}

	public Map upload(MultipartFile multipartFile) throws IOException {
		File file = convert(multipartFile);
		Map result = cloudinary.uploader().upload(file, ObjectUtils.emptyMap());
		file.delete();
		return result;
	}

	public Map delete(String id) throws IOException {
		Map result = cloudinary.uploader().destroy(id, ObjectUtils.emptyMap());
		return result;
	}

	public File convert(MultipartFile multipartFile) throws IOException {
		File file = new File(multipartFile.getOriginalFilename());
		FileOutputStream fo = new FileOutputStream(file);
		fo.write(multipartFile.getBytes());
		fo.close();
		return file;

	}
}
