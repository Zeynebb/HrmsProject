package kodlamaio.hrms.business.concretes;

import java.io.IOException;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import kodlamaio.hrms.business.abstracts.PhotoService;
import kodlamaio.hrms.core.abstracts.CloudinaryService;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.core.utilities.result.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.PhotoDao;
import kodlamaio.hrms.entities.concretes.Photo;

@Service
public class PhotoManager implements PhotoService{

	private PhotoDao photoDao;
	private CloudinaryService cloudinaryservice;
	
	@Autowired
	public PhotoManager(PhotoDao photoDao, CloudinaryService cloudinaryservice) {
		super();
		this.photoDao = photoDao;
		this.cloudinaryservice = cloudinaryservice;
	}

	@Override
	public Result add(Photo photo, MultipartFile multipartFile) throws IOException {
		Map result = cloudinaryservice.photoUpload(multipartFile);
		photo.setPhotoUrl(result.get("url").toString());
		this.photoDao.save(photo);
		//this.photoDao.updatePhotoSetPhotoUrlForCv_cvId(result.get("url").toString(), cvId);
		return new SuccessResult("Fotoğraf Eklendi");
	}

	@Override
	public Result delete(String id) throws IOException {
		this.cloudinaryservice.photoDelete(id);
		return new SuccessResult("Fotoğraf Silindi");
	}

}
